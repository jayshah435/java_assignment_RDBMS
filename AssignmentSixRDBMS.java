package assignment_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//List the Empno, Ename, Sal, Exp of all emps working for Mgr 7369

public class AssignmentSixRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql = "select Empno, Ename, Sal from emp_table_data where Mgr<>7369";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			
			System.out.println("Employee Details Except Those Who Work For Mgr 7369");
			while(rst.next()) {
				System.out.println("Empno: "+rst.getString("Empno")+", Ename: "+rst.getString("Ename")+", Sal: "+rst.getString("Sal"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
