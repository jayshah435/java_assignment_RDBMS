package assignment_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Any jobs of deptno 10 those that are not found in deptno 20.

public class AssignmentSixteenRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql= "select * from emp_table_data E1 where E1.Deptno=10 and E1.job not in (select E2.job from emp_table_data E2 where E2.Deptno=20)";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); 
			
			System.out.println("Employees Who Are From Deptno 10 Have Jobs That Are Not Found In Deptno 20");
			while(rst.next()) {
				System.out.println("Empno: "+rst.getString("Empno")+", Ename: "+rst.getString("Ename")+", Job: "+rst.getString("Job")+", Mgr: "+rst.getString("Mgr")+", Hiredate: "+rst.getString("Hiredate")+", Sal: "+rst.getString("Sal")+", Comm: "+rst.getString("Comm")+", Deptno: "+rst.getString("Deptno"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
