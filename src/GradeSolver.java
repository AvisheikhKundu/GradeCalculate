import javax.swing.*;
import java.awt.event.*;

public class GradeSolver extends JFrame implements ActionListener {

    JTextField quizField =        new JTextField(10);
    JTextField midtermField =     new JTextField(10);
    JTextField attendanceField =  new JTextField(10);
    JTextField assignmentField =  new JTextField(10);
    JTextField presentationField =new JTextField(10);
    JTextField finalField =       new JTextField(10);

    JButton calculateButton = new JButton("Calculate");
    JButton clearButton = new JButton("Clear");

    JLabel remarksLabel = new JLabel();
    JLabel gradeLabel = new JLabel();
    JLabel reportLabel = new JLabel();

    double solve = 0.00;
    double quizValue = 0.00, midtermValue = 0.00, attendanceValue =0.00, assignmentValue =0.00 ,presentationValue =0.00, finalValue = 0.00;

    String remarksText;

    public GradeSolver() {
        super("Grade Solver created by Avisheikh");
        setSize(240, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();

        JLabel quizLabel =        new JLabel("Quiz                      ");
        JLabel midtermLabel =      new JLabel("Midterm                ");
        JLabel attendanceLabel =   new JLabel("Attendance           ");
        JLabel assignmentLabel =   new JLabel("Assignment           ");
        JLabel presentationLabel = new JLabel("Presentation         ");
        JLabel finalLabel =       new JLabel("Finals                     ");

        pane.add(quizLabel);
        pane.add(quizField);

        pane.add(midtermLabel);
        pane.add(midtermField);
        pane.add(attendanceLabel);
        pane.add(attendanceField);
        pane.add(assignmentLabel);
        pane.add(assignmentField);
        pane.add(presentationLabel);
        pane.add(presentationField);
        pane.add(finalLabel);
        pane.add(finalField);
        pane.add(calculateButton);
        pane.add(clearButton);

        calculateButton.addActionListener(this);
        clearButton.addActionListener(this);
        calculateButton.setToolTipText("Click here to solve the grade.");
        clearButton.setToolTipText("Click here to clear text fields.");

        pane.add(reportLabel);
        pane.add(gradeLabel);
        pane.add(remarksLabel);

        add(pane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (calculateButton == e.getSource()) {
            quizValue = Double.parseDouble(quizField.getText()) ;
            midtermValue = Double.parseDouble(midtermField.getText()) ;
            attendanceValue = Double.parseDouble(attendanceField.getText());
            assignmentValue = Double.parseDouble(assignmentField.getText());
            presentationValue = Double.parseDouble(presentationField.getText());
            finalValue = Double.parseDouble(finalField.getText()) ;

            solve = (quizValue + midtermValue + attendanceValue + assignmentValue + presentationValue +  finalValue);

            if (solve >= 80 && solve <= 100) {
                remarksText = "4.00";
            } else if (solve >= 75 && solve <= 79) {
                remarksText = "3.75";
            } else if (solve >= 70 && solve <= 74) {
                remarksText = "3.50";
            } else if (solve >= 65 && solve <= 69) {
                remarksText = "3.25";
            } else if (solve >= 60 && solve <= 64) {
                remarksText = "3.00";
            } else if (solve >= 55 && solve <= 59) {
                remarksText = "2.75";
            } else if (solve >= 50 && solve <= 54) {
                remarksText = "2.50";
            } else if (solve >= 45 && solve <= 49) {
                remarksText = "2.25";
            } else if (solve >= 40 && solve <= 44) {
                remarksText = "2.00";
            } else {
                remarksText = "Student failed the subject.";
            }
        }
//@author AVISHEIKH
        reportLabel.setText(" --  Grade Report  -- ");
        gradeLabel.setText("Student mark is " + String.format("%.0f",   solve) + " and grade is:");

        remarksLabel.setText(remarksText);

        if (clearButton == e.getSource()) {
            quizField.setText("");
            midtermField.setText("");
            attendanceField.setText("");
                    assignmentField.setText("");
            presentationField.setText("");
            finalField.setText("");

            reportLabel.setText("");
            gradeLabel.setText("");
            remarksLabel.setText("");
        }
    }

    public static void main(String[] args) {
        GradeSolver employee = new GradeSolver();
    }
}
