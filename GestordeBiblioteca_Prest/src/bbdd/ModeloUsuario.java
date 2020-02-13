package bbdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class ModeloUsuario extends Conexion{

	public ModeloUsuario(String bbdd, String host, String username, String password) {
		super(bbdd, host, username, password);
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<Usuario> selectALL(){
		int id;
		String nombre,apellido,dni,admin,password;
		ArrayList<Usuario> lista=new ArrayList<Usuario>();

		try {
		
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios");
	
			while (rs.next()) {
				id = rs.getInt("id");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				dni = rs.getString("dni");
				admin= rs.getString("admin");
				password=rs.getString("password");
				
				
				Usuario s1=new Usuario();
				s1.setId(id);
				s1.setNombre(nombre);
				s1.setApellido(apellido);
				s1.setDni(dni);
				s1.setAdmin(admin);
				s1.setPassword(password);
				lista.add(s1);
				
		
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lista;
				
	}
	public ArrayList<Usuario> select_like(String partes) {
		int id;
		String nombre,apellido,dni,admin,password;
		ArrayList<Usuario> lista=new ArrayList<Usuario>();

		try {
		
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios where nombre like '%"+partes+"%'");
	
			while (rs.next()) {
				id = rs.getInt("id");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				dni = rs.getString("dni");
				admin= rs.getString("admin");
				password=rs.getString("password");
				
				
				Usuario s1=new Usuario();
				s1.setId(id);
				s1.setNombre(nombre);
				s1.setApellido(apellido);
				s1.setDni(dni);
				s1.setAdmin(admin);
				s1.setPassword(password);
				lista.add(s1);
		
			}} catch (SQLException e) {
				e.printStackTrace();
			}
		return lista;
				
	}
	public Usuario ver_usuario(String dni){
		Usuario s1=new Usuario();

		try {
		
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios where dni = '"+dni+"'");
	
			while (rs.next()) {
				s1.setId(rs.getInt("id"));
				s1.setNombre(rs.getString("nombre"));
				s1.setApellido(rs.getString("apellido"));
				s1.setDni(rs.getString("dni"));	
				s1.setAdmin(rs.getString("admin"));
				s1.setPassword(rs.getString("password"));
		
			}} catch (SQLException e) {
				e.printStackTrace();
			}
		return s1;
	}
	public void editar_usuario(String password, String dni) throws SQLException {

	
		PreparedStatement pstUpdate = conexion.prepareStatement("UPDATE usuarios set password=? WHERE dni=?");
		pstUpdate.setString(1, password);
		pstUpdate.setString(2, dni);
		pstUpdate.execute();
		
	}
	public void eliminar_usuario(String dni) throws SQLException  {
		
			PreparedStatement pstDelete = conexion.prepareStatement("DELETE FROM usuarios WHERE dni=?");
			
			pstDelete.setString(1, dni);
			pstDelete.execute();

	}
	@Override
	public void cerrarConexion() throws SQLException {
		// TODO Auto-generated method stub
		super.cerrarConexion();
	}
}
