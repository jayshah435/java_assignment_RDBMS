package assignment_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Display all the details of the emps who’s Comm. Is more than their Sal?

public class AssignmentSevenRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql = "select * from emp_table_data where Comm>Sal";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			
			System.out.println("Employee Details Whose Comm. Greater Than Their Sal");
			while(rst.next()) {
				System.out.println("Empno: "+rst.getString("Empno")+", Ename: "+rst.getString("Ename")+", Job: "+rst.getString("Job")+", Mgr: "+rst.getString("Mgr")+", Hiredate: "+rst.getString("Hiredate")+", Sal: "+rst.getString("Sal")+", Comm: "+rst.getString("Comm")+", Deptno: "+rst.getString("Deptno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
