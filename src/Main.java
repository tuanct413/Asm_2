public class Main {
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
