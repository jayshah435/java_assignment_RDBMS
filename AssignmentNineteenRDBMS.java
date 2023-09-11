package assignment_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Find the total sal given to the MGR

public class AssignmentNineteenRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql = "select Sum(Sal) as TotalSal from emp_table_data";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); 
			
			System.out.println("Total Salary Given To The MGR");
			while(rst.next()) {
				System.out.println(rst.getString("TotalSal"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
