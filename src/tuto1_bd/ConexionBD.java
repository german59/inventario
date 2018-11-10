package tuto1_bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

	static String bd = "tuto1_bd";
		static String login = "postgres";
		static String password = "1234";
		static String url = "jdbc:postgresql://127.0.0.1:5434/"+bd;
		Connection conexion = null;
		
		
		
		public ConexionBD() {
			
			
			try {
				Class.forName("org.postgresql.Driver");
				conexion = DriverManager.getConnection(url, login, password);
				
				
			}catch(Exception e) {
				System.out.println("error"+e);
			}
			
			
		}
		
		
		public Connection getConnection() {
			return conexion;
		}
		
		public void desconectar() {
			conexion=null;
		}
		
		
		
}