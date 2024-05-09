package StudentInfo;

import java.sql.*;

public class StudentDB {
	private static final String URL = "jbdc:mysql://localhost:3306/studentinfo";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	
	public void addStudent(Student student)
	{
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement statement = conn.prepareStatement("INSERT INTO studentstable (Name, RollNumber, Grade) VALUES (?, ?, ?)") ) {
			statement.setString(1,  student.getName());
			statement.setInt(2,  student.getRollNumber());
			statement.setDouble(2, student.getGrade());
			statement.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void removeStudent(int rollNumber)
	{
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement statement = conn.prepareStatement("DELETE FROM studentstablE WHERE rollNumber = ?") ) {
			statement.setInt(1,  rollNumber);
			statement.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
  public String getAllStudentsData() {
  StringBuilder studentsData = new StringBuilder();
  try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT * FROM studentstable")) {
      while (rs.next()) {
          int rollNumber = rs.getInt("RollNumber");
          String name = rs.getString("Name");
          double grade = rs.getDouble("Grade");
          studentsData.append("Name: ").append(name).append(", Roll Number: ").append(rollNumber).append(", Grade: ").append(grade).append("\n");
      }
  } catch (SQLException e) {
      e.printStackTrace();
  }
  return studentsData.toString();
}
	
}