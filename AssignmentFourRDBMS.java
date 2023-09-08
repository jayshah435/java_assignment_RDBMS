package assignment_RDBMS;

//List the emps who joined before 1981.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AssignmentFourRDBMS {
	public static void main(String[] args) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
		String sql = "select * from emp_table_data where year(Hiredate)<1981";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rst = pst.executeQuery();
		System.out.println("Employees Who Joined Before 1981: ");
			while(rst.next()) {
				System.out.println(rst.getString("Ename"));
			}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
