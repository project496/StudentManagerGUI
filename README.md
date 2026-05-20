# Student Manager GUI System

## Overview

The **Student Manager GUI System** is a Java Swing-based desktop application that allows users to manage student records efficiently. The application provides features such as:

* Adding student records
* Displaying students department-wise
* Generating merit lists
* GUI-based interaction using Java Swing

This project demonstrates the use of:

* Object-Oriented Programming (OOP)
* Java Swing GUI
* Event Handling
* ArrayList Collections
* Sorting Algorithms

---

# Features

## Student Record Management

Users can:

* Enter student details
* Store records dynamically
* View records by department
* Generate merit lists based on marks

## Departments Included

* CS
* AI
* CYBER
* SE

## Merit List System

Students are sorted in descending order based on marks.

---

# Technologies Used

* Java
* Java Swing
* OOP Concepts
* ArrayList
* Event Listeners

---

# Project Structure

```bash
StudentManagerGUI/
│
├── Student.java
├── StudentManagerGUI.java
└── README.md
```

---

# StudentManagerGUI Class

The `StudentManagerGUI` class is the main controller of the application.

It handles:

* Student data entry
* Displaying records
* Merit list generation
* GUI navigation

## Instance Variable

```java
private ArrayList<Student> students;
```

This `ArrayList` stores all student records entered by the user.

---

# Constructor

```java
public StudentManagerGUI() {
    students = new ArrayList<>();
}
```

Initializes the student list.

---

# Main Method

```java
public static void main(String[] args) {
    StudentManagerGUI manager = new StudentManagerGUI();
    manager.showStudentEntryForm();
}
```

This is the entry point of the application.

---

# Student Entry Form

The `showStudentEntryForm()` method creates the GUI form for entering student details.

## Input Fields

* Roll Number
* Name
* Department
* Marks

## GUI Components Used

* `JFrame`
* `JPanel`
* `JLabel`
* `JTextField`
* `JButton`

---

# Submit Button Functionality

```java
submitButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String rollNumber = rollNumberField.getText();
        String name = nameField.getText();
        String department = departmentField.getText();
        int marks = Integer.parseInt(marksField.getText());

        students.add(new Student(rollNumber, name, department, marks));

        frame.dispose();
        showPostEntryOptions();
    }
});
```

When the user clicks the submit button:

1. Data is collected from input fields
2. A new `Student` object is created
3. The record is added to the ArrayList
4. The next options screen opens

---

# Post Entry Options

After submitting a student record, users can:

* Enter another record
* Display students
* View merit list
* Exit application

---

# Department Selection

The application allows filtering students department-wise using `JComboBox`.

```java
String[] departments = { "CS", "AI", "CYBER", "SE" };
```

---

# Display Students

```java
public void displayStudents(String department)
```

This method:

* Filters students by department
* Displays records using `JOptionPane`

---

# Merit List Generation

```java
public void displayMeritList(String department)
```

This method:

1. Collects students of the selected department
2. Sorts them according to marks
3. Displays the merit list

## Sorting Logic

```java
departmentStudents.sort((s1, s2) -> s2.getMarks() - s1.getMarks());
```

Students with higher marks appear first.

---

# Student Class

The `Student` class represents a student object.

## Attributes

```java
private String rollNumber;
private String name;
private String department;
private int marks;
```

---

# Constructor

```java
public Student(String rollNumber, String name, String department, int marks) {
    this.rollNumber = rollNumber;
    this.name = name;
    this.department = department;
    this.marks = marks;
}
```

---

# Getter Methods

```java
public String getRollNumber() { return rollNumber; }
public String getName() { return name; }
public String getDepartment() { return department; }
public int getMarks() { return marks; }
```

---

# Display Method

```java
public String display() {
    return "Roll Number: " + rollNumber + "\n" +
           "Name: " + name + "\n" +
           "Department: " + department + "\n" +
           "Marks: " + marks;
}
```

Returns formatted student information.

---

# How to Run the Project

## Step 1

Clone the repository:

```bash
git clone https://github.com/your-username/StudentManagerGUI.git
```

## Step 2

Open the project in:

* IntelliJ IDEA
* NetBeans
* Eclipse
* VS Code

## Step 3

Compile and run:

```bash
javac Student.java StudentManagerGUI.java
java StudentManagerGUI
```

---

# Future Improvements

Possible future enhancements:

* Database integration (MySQL)
* Login system
* Search functionality
* Update/Delete student records
* Export data to PDF/Excel
* Better UI design

---

# Learning Outcomes

This project helps in understanding:

* Java GUI development
* OOP implementation
* Event-driven programming
* Data management using ArrayList
* Sorting techniques

---

# License

This project is for educational purposes.

---

# Author

Developed using Java Swing and Object-Oriented Programming concepts.
