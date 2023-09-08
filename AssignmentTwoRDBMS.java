package assignment_RDBMS;

//List the details of the emps in asc order of the Dptnos and desc of Jobs

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AssignmentTwoRDBMS {
	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql1 = "select * from emp_table_data order by Deptno asc";
			PreparedStatement pst1 = conn.prepareStatement(sql1);
			ResultSet rst1 = pst1.executeQuery();
			
			String sql2 = "select * from emp_table_data order by Job desc";
			PreparedStatement pst2 = conn.prepareStatement(sql2);
			ResultSet rst2 = pst2.executeQuery();
			
			System.out.println("***************************************************");
			System.out.println("Details Of Employees In Asc Order Of Deptno");
				while(rst1.next()) {
					String empno = rst1.getString("Empno");
					String ename = rst1.getString("Ename");
					String job = rst1.getString("Job");
					String mgr = rst1.getString("Mgr");
					String hiredate = rst1.getString("Hiredate");
					String sal = rst1.getString("Sal");
					String comm = rst1.getString("Comm");
					String deptno = rst1.getString("Deptno");

					System.out.println("*****************");
					System.out.println("Dept No: "+ deptno);
					System.out.println("Emp No: "+ empno);
					System.out.println("Emp Name: "+ ename);
					System.out.println("Job: "+ job);
					System.out.println("Mgr: "+ mgr);
					System.out.println("Hire Date: "+ hiredate);
					System.out.println("Salary: "+ sal);
					System.out.println("Comm: "+ comm);
					
				}
			
			System.out.println("***************************************************");
			
			System.out.println("***************************************************");
			System.out.println("Details Of Employees In Desc Order Of Jobs");
			
				while(rst2.next()) {
					String empno = rst2.getString("Empno");
					String ename = rst2.getString("Ename");
					String job = rst2.getString("Job");
					String mgr = rst2.getString("Mgr");
					String hiredate = rst2.getString("Hiredate");
					String sal = rst2.getString("Sal");
					String comm = rst2.getString("Comm");
					String deptno = rst2.getString("Deptno");

					System.out.println("*****************");
					System.out.println("Job: "+ job);
					System.out.println("Dept No: "+ deptno);
					System.out.println("Emp No: "+ empno);
					System.out.println("Emp Name: "+ ename);
					System.out.println("Mgr: "+ mgr);
					System.out.println("Hire Date: "+ hiredate);
					System.out.println("Salary: "+ sal);
					System.out.println("Comm: "+ comm);
					
				}
			
			System.out.println("***************************************************");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
