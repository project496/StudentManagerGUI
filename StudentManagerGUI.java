import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentManagerGUI {

    private ArrayList<Student> students;

    public StudentManagerGUI() {
        students = new ArrayList<>();
    }

    public static void main(String[] args) {
        StudentManagerGUI manager = new StudentManagerGUI();
        manager.showStudentEntryForm();
    }

    public void showStudentEntryForm() {

        JFrame frame = new JFrame("Enter Student Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        frame.add(panel);

        panel.add(new JLabel("Roll Number:"));
        JTextField rollNumberField = new JTextField();
        panel.add(rollNumberField);

        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Department:"));
        JTextField departmentField = new JTextField();
        panel.add(departmentField);

        panel.add(new JLabel("Marks:"));
        JTextField marksField = new JTextField();
        panel.add(marksField);

        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);

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

        frame.setVisible(true);
    }

    public void showPostEntryOptions() {

        JFrame frame = new JFrame("Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();

        frame.add(panel);

        JButton enterAnotherButton = new JButton("Enter Another Record");
        JButton displayButton = new JButton("Display Students");
        JButton meritListButton = new JButton("Merit List");
        JButton exitButton = new JButton("Exit");

        panel.add(enterAnotherButton);
        panel.add(displayButton);
        panel.add(meritListButton);
        panel.add(exitButton);

        enterAnotherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showStudentEntryForm();
                frame.dispose();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showDepartmentSelectionForDisplay();
            }
        });

        meritListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                showDepartmentSelectionForMeritList();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    public void showDepartmentSelectionForDisplay() {

        JFrame frame = new JFrame("Select Department for Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();

        frame.add(panel);

        String[] departments = {"CS", "AI", "CYBER", "SE"};

        JComboBox<String> departmentComboBox = new JComboBox<>(departments);

        panel.add(departmentComboBox);

        JButton submitButton = new JButton("Submit");

        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedDepartment =
                        (String) departmentComboBox.getSelectedItem();

                displayStudents(selectedDepartment);

                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public void displayStudents(String department) {

        StringBuilder departmentStudents = new StringBuilder();

        for (Student student : students) {

            if (student.getDepartment().equals(department)) {

                departmentStudents
                        .append(student.display())
                        .append("\n\n");
            }
        }

        JOptionPane.showMessageDialog(
                null,
                departmentStudents.toString(),
                "Student Records - " + department,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void showDepartmentSelectionForMeritList() {

        JFrame frame = new JFrame("Select Department for Merit List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();

        frame.add(panel);

        String[] departments = {"CS", "AI", "CYBER", "SE"};

        JComboBox<String> departmentComboBox =
                new JComboBox<>(departments);

        panel.add(departmentComboBox);

        JButton submitButton = new JButton("Submit");

        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedDepartment =
                        (String) departmentComboBox.getSelectedItem();

                displayMeritList(selectedDepartment);

                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public void displayMeritList(String department) {

        ArrayList<Student> departmentStudents = new ArrayList<>();

        for (Student student : students) {

            if (student.getDepartment().equals(department)) {

                departmentStudents.add(student);
            }
        }

        departmentStudents.sort(
                (s1, s2) -> s2.getMarks() - s1.getMarks()
        );

        StringBuilder meritList = new StringBuilder();

        for (Student student : departmentStudents) {

            meritList
                    .append(student.display())
                    .append("\n\n");
        }

        JOptionPane.showMessageDialog(
                null,
                meritList.toString(),
                "Merit List - " + department,
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
