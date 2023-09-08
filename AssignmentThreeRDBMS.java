package assignment_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Display all the unique job groups in the descending order

public class AssignmentThreeRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql = "select distinct Job from emp_table_data order by Job desc";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			System.out.println("Unique Job Groups In Desc Order: ");
				while(rst.next()) {
					System.out.println(rst.getString("job"));
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
