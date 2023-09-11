package assignment_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Find all the emps who earn the minimum Salary for each job wise in ascending order.

public class AssignmentTwentyOneRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql = "select * from emp_table_data E1 where E1.Sal = (select Min(E2.Sal) from emp_table_data E2 where E1.Job=E2.Job) order by E1.Job asc";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery(); 
			
			System.out.println("Employees WhoEarn Minimum Salary For Each Job Wise In Ascending Order");
			while(rst.next()) {
				System.out.println("Empno: "+rst.getString("Empno")+", Ename: "+rst.getString("Ename")+", Job: "+rst.getString("Job")+", Mgr: "+rst.getString("Mgr")+", Hiredate: "+rst.getString("Hiredate")+", Sal: "+rst.getString("Sal")+", Comm: "+rst.getString("Comm")+", Deptno: "+rst.getString("Deptno"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
