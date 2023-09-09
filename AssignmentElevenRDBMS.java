package assignment_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//List all the Clerks of Deptno 20

public class AssignmentElevenRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql = "select * from emp_table_data where Job in ('CLERK') and Deptno=20";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			
			System.out.println("Employees Who Are Clerks And From Deptno 20");
			while(rst.next()) {
				System.out.println("Ename: "+rst.getString("Ename")+", Job: "+rst.getString("Job")+", Deptno: "+rst.getString("Deptno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
