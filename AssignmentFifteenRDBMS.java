package assignment_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//List the emps whose jobs same as SMITH or ALLEN.

public class AssignmentFifteenRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			String sql = "select * from emp_table_data E1 where E1.Job in (select E2.Job from emp_table_data E2 where E2.Ename in ('SMITH') or Ename in ('ALLEN'))";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); 
			
			System.out.println("Employees Who's Jobs Are Same As SMITH Or ALLEN.");
			while(rst.next()) {
				System.out.println("Empno: "+rst.getString("Empno")+", Ename: "+rst.getString("Ename")+", Job: "+rst.getString("Job")+", Mgr: "+rst.getString("Mgr")+", Hiredate: "+rst.getString("Hiredate")+", Sal: "+rst.getString("Sal")+", Comm: "+rst.getString("Comm")+", Deptno: "+rst.getString("Deptno"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
