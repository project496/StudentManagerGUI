public class Student {

    private String rollNumber;
    private String name;
    private String department;
    private int marks;

    public Student(String rollNumber, String name, String department, int marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getMarks() {
        return marks;
    }

    public String display() {
        return "Roll Number: " + rollNumber +
                "\nName: " + name +
                "\nDepartment: " + department +
                "\nMarks: " + marks;
    }
}
