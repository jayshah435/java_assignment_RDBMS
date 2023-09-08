package assignment_RDBMS;

//Select unique job from EMP table.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AssignmentOneRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql= "select distinct Job from emp_table_data";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rst= pst.executeQuery();	
			
			System.out.println("Unique Job Data: ");
				while(rst.next()) {
					String uniqueJob = rst.getString("Job");
					System.out.println(uniqueJob);
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
