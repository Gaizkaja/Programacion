package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexion {
protected Connection conexion;
protected String bbdd;
protected String host;
protected String username;
protected String password;

public Conexion(String bbdd, String host, String username, String password) {
	super();
	this.bbdd = bbdd;
	this.host = host;
	this.username = username;
	this.password = password;

	
try {
		Class.forName("com.mysql.jdbc.Driver");
		conexion = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + "/" + bbdd, username, password);
		
	
}catch (ClassNotFoundException e) {
		e.printStackTrace();
}
catch (SQLException e) {
	e.printStackTrace();
}
}
public void cerrarConexion() throws SQLException{
	this.conexion.close();
}
}