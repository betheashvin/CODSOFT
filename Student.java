package StudentInfo;

public class Student {
	private String name;
	private int rollNumber;
	private double grade;
	
	public Student(String name, int rollNumber, double grade)
	{
		this.name = name;
		this.rollNumber = rollNumber;
		this.grade = grade;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getRollNumber()
	{
		return rollNumber;
	}
	
	public double getGrade()
	{
		return grade;
	}
}


