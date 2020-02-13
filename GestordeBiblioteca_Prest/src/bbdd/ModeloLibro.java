package bbdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ModeloLibro extends Conexion {
	public static Scanner sc = new Scanner(System.in);
	public ModeloLibro(String bbdd, String host, String username, String password) {
		super(bbdd, host, username, password);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Libros> selectALL(){
		int id,numPags;
		String titulo,autor;
		ArrayList<Libros> lista=new ArrayList<Libros>();

		try {
			
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros");
	
			while (rs.next()) {
				id = rs.getInt("id");
				titulo = rs.getString("titulo");
				autor = rs.getString("autor");
				numPags = rs.getInt("num_pag");				
				
				Libros l1=new Libros();
				l1.setId(id);
				l1.setTitulo(titulo);
				l1.setAutor(autor);
				l1.setNumPags(numPags);
				lista.add(l1);
				
		
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lista;
				
	}
	public ArrayList<Libros> select_like(String partes) {
		int id,numPags;
		String titulo,autor;
	
		ArrayList<Libros> lista=new ArrayList<Libros>();

		try {
		
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros where nombre like '%"+partes+"%'");
	
			while (rs.next()) {
				id = rs.getInt("id");
				titulo = rs.getString("titulo");
				autor = rs.getString("autor");
				numPags = rs.getInt("num_pag");				
				
				Libros l1=new Libros();
				l1.setId(id);
				l1.setTitulo(titulo);
				l1.setAutor(autor);
				l1.setNumPags(numPags);
				lista.add(l1);
				
			}} catch (SQLException e) {
				e.printStackTrace();
			}
		return lista;
				
	}
	public Libros ver_libro(String nombre){
		Libros l1=new Libros();

		try {
		
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros where nombre = '"+nombre+"'");
	
			while (rs.next()) {
				l1.setId(rs.getInt("id"));
				l1.setTitulo(rs.getString("titulo"));
				l1.setAutor(rs.getString("autor"));
				l1.setNumPags(rs.getInt("num_pag"));	
				
		
			}} catch (SQLException e) {
				e.printStackTrace();
			}
		return l1;
	}
	public void editar_libro(String titulo, int num) throws SQLException {
		
		PreparedStatement pstUpdate;
		pstUpdate = conexion.prepareStatement("update libros set num_pag=? where titulo=?");
		
		pstUpdate.setInt(1, num);
		
		pstUpdate.setString(2, titulo);
		pstUpdate.executeUpdate();
		
		
	}
	public void eliminar_libro(int id) throws SQLException {
		
		
			PreparedStatement pstDelete = conexion.prepareStatement("DELETE FROM libros WHERE id=?");
			
			pstDelete.setInt(1, id);
			pstDelete.execute();
			
		
		

	}
	@Override
	public void cerrarConexion() throws SQLException {
		// TODO Auto-generated method stub
		super.cerrarConexion();
	}

}
