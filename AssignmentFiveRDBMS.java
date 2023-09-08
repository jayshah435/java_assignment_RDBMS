package assignment_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//List the Empno, Ename, Sal, Daily sal of all emps in the asc order of Annsal

public class AssignmentFiveRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql = "select Empno, Ename, sal from emp_table_data order by sal asc";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			
			System.out.println("Employee Details In Asc Order Of Salary");
			while(rst.next()) {
				System.out.println("Empno: "+rst.getString("Empno")+" Ename: "+rst.getString("Ename")+" Sal: "+rst.getString("sal"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
