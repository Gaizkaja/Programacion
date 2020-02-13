package bbdd;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloPrestamo extends Conexion {

	public ModeloPrestamo(String bbdd, String host, String username, String password) {
		super(bbdd, host, username, password);
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Prestamo> selectAll() throws SQLException{
		ArrayList<Prestamo> prestamo= new ArrayList<Prestamo>();
		Date fecha;
		boolean devuelto;
		Libros libro;
		Socio socio;;

		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM prestamos INNER JOIN libros on prestamos.id_libro=libros.id INNER JOIN socios on prestamos.id_socio=socios.id");
		while (rs.next()) {
			fecha=rs.get
		}
		return prestamo;
		
		
	}

}
