package assignment_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Find the highest sal of EMP table.

public class AssignmentSeventeenRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql= "select MAX(Sal) as HighestSalary from emp_table_data";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); 
			
			System.out.println("Highest Salary");
			while(rst.next()) {
				System.out.println(rst.getString("HighestSalary"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
