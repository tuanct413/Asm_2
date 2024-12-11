// Student.java

public class Student {
    private int id;
    private String name;
    private double marks;
    private String ranking;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.ranking = calculateRank(marks);
    }

    // Rank calculation based on marks
    public String calculateRank(double marks) {
        if (marks < 5.0) return "Fail";
        else if (marks >= 5.0 && marks < 6.5) return "Medium";
        else if (marks >= 6.5 && marks < 7.5) return "Good";
        else if (marks >= 7.5 && marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getRanking() {
        return ranking;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.ranking = calculateRank(marks);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Rank: " + ranking;
    }
}
