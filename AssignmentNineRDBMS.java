package assignment_RDBMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//List the Enames those are starting with ‘S’ and with five characters

public class AssignmentNineRDBMS {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_assignment","root","");
			
			String sql = "select * from emp_table_data where Length(Ename)=5 and Ename like 'S%'";
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			
			System.out.println("Employee Names Who Are Starting With 'S' And With 5 Characters");
			while(rst.next()) {
				System.out.println("Ename: "+rst.getString("Ename"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
