package kontsultak;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Driver kargatu
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Konexioa sortu
			String url = "jdbc:mysql://localhost:3307/db_empresa";
			String user = "root";
			String pass = "";
			
			
				Connection con = DriverManager.getConnection(url, user, pass);
				
		// Kontsulta prestatu
				
		Statement sta = con.createStatement();
		String sqlKon = "SELECT apellido, oficio, salario from empleados where dept_no = 10";
		ResultSet res = sta.executeQuery(sqlKon);
		
		// Lerro guztiak irakurriko ditugu banan-banan
		
		while (res.next()) {
			System.out.println(res.getString("apellido") + " " + res.getString("oficio") + " " + res.getInt("salario"));
		}
		
		// Itxi dena ordenean
		
		res.close();
		sta.close();
		con.close();
				
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}