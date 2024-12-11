import java.util.Random;

public class StudentManagement {
    private StudentStack students;

    // Constructor với sức chứa mặc định của stack
    public StudentManagement() {
        students = new StudentStack(1000000); // Sức chứa mặc định là 10000
    }

    // Constructor sao chép
    public StudentManagement(StudentManagement other) {
        this.students = new StudentStack(other.students.size());
        for (int i = 0; i < other.students.size(); i++) {
            Student temp = other.students.pop();
            this.students.push(new Student(temp.getId(), temp.getName(), temp.getMarks()));
            other.students.push(temp); // Đảm bảo stack ban đầu không thay đổi
        }
    }

    // Thêm một Student vào stack
    public void addStudent(int id, String name, double marks) {
        if (students.isFull()) {
            System.out.println("Stack is full! Cannot add more students.");
        } else {
            students.push(new Student(id, name, marks));
        }
    }

    // Sửa điểm của một Student theo ID
    public void editStudent(int id, double newMarks) {
        StudentStack tempStack = new StudentStack(students.size());
        boolean found = false;

        while (!students.isEmpty()) {
            Student current = students.pop();
            if (current.getId() == id) {
                current.setMarks(newMarks);
                found = true;
            }
            tempStack.push(current);
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Student details updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Xóa một Student theo ID
    public void deleteStudent(int id) {
        StudentStack tempStack = new StudentStack(students.size());
        boolean found = false;

        while (!students.isEmpty()) {
            Student current = students.pop();
            if (current.getId() == id) {
                found = true;
            } else {
                tempStack.push(current);
            }
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Tìm kiếm một Student theo ID
    public Student searchStudent(int id) {
        StudentStack tempStack = new StudentStack(students.size());
        Student foundStudent = null;

        while (!students.isEmpty()) {
            Student current = students.pop();
            if (current.getId() == id) {
                foundStudent = current;
            }
            tempStack.push(current);
        }

        while (!tempStack.isEmpty()) {
            students.push(tempStack.pop());
        }

        if (foundStudent == null) {
            System.out.println("Student not found.");
        }

        return foundStudent;
    }

    // Hiển thị tất cả các Student
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            StudentStack tempStack = new StudentStack(students.size());

            while (!students.isEmpty()) {
                Student current = students.pop();
                System.out.println(current);
                tempStack.push(current);
            }

            while (!tempStack.isEmpty()) {
                students.push(tempStack.pop());
            }
        }
    }

    // Sắp xếp sinh viên bằng Bubble Sort
    public void bubbleSort() {
        int n = students.size();
        Student[] array = new Student[n];

        // Chuyển stack thành mảng
        for (int i = 0; i < n; i++) {
            array[i] = students.pop();
        }

        // Bubble sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].getMarks() < array[j + 1].getMarks()) {
                    Student temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // Chuyển mảng về stack
        for (int i = n - 1; i >= 0; i--) {
            students.push(array[i]);
        }
    }

    // Sắp xếp sinh viên bằng Merge Sort
    public void mergeSort() {
        int n = students.size();
        Student[] array = new Student[n];

        // Chuyển stack thành mảng
        for (int i = 0; i < n; i++) {
            array[i] = students.pop();
        }

        // Merge sort
        mergeSortHelper(array, 0, n - 1);

        // Chuyển mảng về stack
        for (int i = n - 1; i >= 0; i--) {
            students.push(array[i]);
        }
    }

    // Hàm hỗ trợ Merge Sort
    private void mergeSortHelper(Student[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSortHelper(array, left, mid);
            mergeSortHelper(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private void merge(Student[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].getMarks() >= rightArray[j].getMarks()) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
}
