package com.sunbeam.p1;
import java.sql.*;
public class program2 {
	
	private static final String URL="jdbc:mysql://localhost:3306/internship_db";
	private static final String USERNAME="root";
	private static final String PASSWORD="manager";
	
	public static Connection getConnection()throws SQLException{
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
	}

	public static void getAllStudents() {
		String sql="SELECT * FROM students";
		try {
			Connection connection=getConnection();
			PreparedStatement selectStatement= connection.prepareStatement(sql);
			ResultSet rs=selectStatement.executeQuery();
			while(rs.next()) {
				int rollno=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String course=rs.getString(4);
				System.out.println(rollno + "-" + name + "-" + email + "-" + course);
			}
			connection.close();
			selectStatement.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addStudent() {
		String name ="Piyush";
		String email="piyush@gmail.com";
		String course="Java";
		
		String sql = "INSERT INTO students(name,email,course) VALUES(?,?,?)";
		try {
			Connection connection =getConnection();
			PreparedStatement insertStatement=connection.prepareStatement(sql);
			insertStatement.setString(1, name);
			insertStatement.setString(2, email);
			insertStatement.setString(3, course);
			insertStatement.executeUpdate();
			connection.close();
			insertStatement.close();
			System.out.println("Student Inserted");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateStudent() {
        int rollno=5;
	    String name = "piyush";
	    String email = "piyush@gmail.com";
	    String course = "WEBPYTHON";

	    String sql = "UPDATE students SET name=?,email=?,course=? WHERE rollno=?";
	    try {
	        Connection connection=getConnection();
	        PreparedStatement updateStatement = connection.prepareStatement(sql);
	        updateStatement.setString(1, name);
	        updateStatement.setString(2, email);
	        updateStatement.setString(3, course);
	        updateStatement.setInt(4, rollno);
	        updateStatement.executeUpdate();
	        System.out.println(" Student Updated");
	        updateStatement.close();
	        connection.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void deleteStudent() {
		int rollno=6;
	    String sql="Delete from students where rollno=?";
	    try {
	        Connection connection=getConnection();
	        PreparedStatement deleteStatement=connection.prepareStatement(sql);
	        deleteStatement.setInt(1, rollno);
	        deleteStatement.executeUpdate();
	        connection.close();
	        deleteStatement.close();
	        System.out.println("Student deleted");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public static void main(String[] args) {
		
		getAllStudents();
		addStudent();
		deleteStudent();
		updateStudent();
	}

}


/*
  package com.sunbeam.
 
 */
