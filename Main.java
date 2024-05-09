package StudentInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//@SuprressWarnings("serial");
public class Main extends JFrame {
	private JTextField nameF, rollNumberF, gradeF;
	private JTextArea studentListArea;
	private StudentDB db;
	
	public Main()
	{
		setTitle("Student Management System");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel inputP = new JPanel(new GridLayout(4, 2));
		inputP.add(new JLabel("Name: "));
		nameF = new JTextField();
		inputP.add(nameF);
		
		inputP.add(new JLabel("Roll Number"));
		rollNumberF = new JTextField();
		inputP.add(rollNumberF);
		
		inputP.add(new JLabel("Grade"));
		gradeF = new JTextField();
		inputP.add(gradeF);
		
		JPanel buttonP = new JPanel(new FlowLayout());
		
		JButton addB = new JButton("Add Student");
		addB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{addStudent();}
		});
		
		JButton displayB = new JButton("Display Students");
		displayB.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e)
			{displayStudents();}
				});
		
		JButton removeB = new JButton("Remove Student");
		removeB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{removeStudent();}
		});
		
		buttonP.add(addB);
		buttonP.add(displayB);
		buttonP.add(removeB);
		
		studentListArea = new JTextArea();
		studentListArea.setEditable(false);
		JScrollPane scrollP = new JScrollPane(studentListArea);
		
		add(inputP, BorderLayout.NORTH);
		add(scrollP, BorderLayout.CENTER);
		add(buttonP, BorderLayout.SOUTH);
		
		db = new StudentDB();
	}
	
	private void addStudent()
	{
		String name = nameF.getText().trim();
		String rollNumber = rollNumberF.getText().trim();
		String grade = gradeF.getText().trim();
		
		if (name.isEmpty() || rollNumber.isEmpty() || grade.isEmpty())
		{
			JOptionPane.showMessageDialog(this,  "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE );
			return;
		}
		
		try {
			int rollNumberInt = Integer.parseInt(rollNumber);
			double gradeDouble = Double.parseDouble(grade);
			
			Student student = new Student(name, rollNumberInt, gradeDouble);
			db.addStudent(student);
			clearFields();
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,  "Invalid input format!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void removeStudent()
	{
		String rollNumberS = JOptionPane.showInputDialog(this, "Enter Roll Number of the student to remove: ");
		if (rollNumberS == null)
			return;
		
		try {
			int rollNumber = Integer.parseInt(rollNumberS);
			db.removeStudent(rollNumber);
			displayStudents();
		} catch (NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(this, "Invalid roll number format!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void displayStudents() {
		studentListArea.setText("");
		String studentsData = db.getAllStudentsData();
		studentListArea.setText(studentsData);
	}
	
	private void clearFields()
	{
		nameF.setText("");
		rollNumberF.setText("");
		gradeF.setText("");

	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Main gui = new Main();
				gui.setVisible(true);
			}
		});
	}
	
	
}