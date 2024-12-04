// StudentManagement.java

import java.util.*;

public class StudentManagement {
    private List<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }

    // Add a student
    public void addStudent(int id, String name, double marks) {
        students.add(new Student(id, name, marks));
    }

    // Edit student details by ID
    public void editStudent(int id, double newMarks) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setMarks(newMarks);
                System.out.println("Student details updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                System.out.println("Student deleted.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Search for a student by ID
    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        System.out.println("Student not found.");
        return null;
    }

    // Sort students by marks
    public void sortStudents() {
        Collections.sort(students, Comparator.comparingDouble(Student::getMarks).reversed());
    }

    // Display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();

        // Add students
        management.addStudent(1, "John Doe", 8.5);
        management.addStudent(2, "Jane Smith", 6.0);
        management.addStudent(3, "Alice Johnson", 9.2);

        // Display all students
        System.out.println("\nAll Students:");
        management.displayStudents();

        // Edit a student's marks
        management.editStudent(2, 7.5);

        // Display updated students
        System.out.println("\nUpdated Students:");
        management.displayStudents();

        // Delete a student
        management.deleteStudent(1);

        // Display remaining students
        System.out.println("\nRemaining Students:");
        management.displayStudents();

        // Search for a student by ID
        Student student = management.searchStudent(3);
        if (student != null) {
            System.out.println("\nStudent found: " + student);
        }

        // Sort students by marks
        management.sortStudents();
        System.out.println("\nSorted Students by Marks:");
        management.displayStudents();
    }
}
