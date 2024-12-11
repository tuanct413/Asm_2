import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Hiển thị menu
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Students");
            System.out.println("2. Edit Student Marks");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Display All Students");
            System.out.println("6. Sort Students (Bubble Sort)");
            System.out.println("7. Compare Bubble Sort and Merge Sort");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng trống

            switch (choice) {
                case 1: // Add Students
                    System.out.print("Enter the number of students to add: ");
                    int numStudents = scanner.nextInt();

                    for (int i = 0; i < numStudents; i++) {
                        System.out.println("\nEnter details for student " + (i + 1) + ":");
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Đọc bỏ dòng trống
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = scanner.nextDouble();

                        management.addStudent(id, name, marks);
                    }
                    break;

                case 2: // Edit Student Marks
                    System.out.print("Enter ID of the student to edit marks: ");
                    int editId = scanner.nextInt();
                    System.out.print("Enter new marks: ");
                    double newMarks = scanner.nextDouble();
                    management.editStudent(editId, newMarks);
                    break;

                case 3: // Delete Student
                    System.out.print("Enter ID of the student to delete: ");
                    int deleteId = scanner.nextInt();
                    management.deleteStudent(deleteId);
                    break;

                case 4: // Search Student by ID
                    System.out.print("Enter ID of the student to search: ");
                    int searchId = scanner.nextInt();
                    Student student = management.searchStudent(searchId);
                    if (student != null) {
                        System.out.println("\nStudent found: " + student);
                    }
                    break;

                case 5: // Display All Students
                    System.out.println("\nAll Students:");
                    management.displayStudents();
                    break;

                case 6: // Sort Students using Bubble Sort
                    long startTimeBubble = System.nanoTime();
                    management.bubbleSort();
                    long endTimeBubble = System.nanoTime();
                    System.out.println("\nBubble Sort Time: " + (endTimeBubble - startTimeBubble) / 1_000_000.0 + " ms");
                    break;

                case 7: // Compare Bubble Sort and Merge Sort
                    Random random = new Random();

                    // Thêm 1000 sinh viên ngẫu nhiên vào quản lý
                    for (int i = 0; i < 1000; i++) {
                        int id = i + 1; // ID duy nhất
                        String name = "Student_" + id; // Tên sinh viên
                        double marks = random.nextDouble() ; // Điểm ngẫu nhiên từ 0 đến 10
                        management.addStudent(id, name, marks);
                    }

                    System.out.println("1000 students added successfully!");

                    // Sao chép danh sách sinh viên từ management sang các đối tượng quản lý khác
                    StudentManagement managementForMerge = new StudentManagement(management);
                    StudentManagement managementForBubble = new StudentManagement(management);

                    // Merge Sort
                    long startTimeMerge = System.nanoTime();
                    managementForMerge.mergeSort();
                    long endTimeMerge = System.nanoTime();
                    System.out.println("Merge Sort Time: " + (endTimeMerge - startTimeMerge)+" Nanotime");

                    // Bubble Sort
                    startTimeBubble = System.nanoTime();
                    managementForBubble.bubbleSort();
                    endTimeBubble = System.nanoTime();
                    System.out.println("Bubble Sort Time: " + (endTimeBubble - startTimeBubble)+" Nanotime");


                    break;

                case 0: // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
