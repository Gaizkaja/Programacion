package bbdd;

import java.sql.Date;

public class Prestamo {
private Date fecha;
private boolean devuelto;
private Libros libro;
private Socio socio;

public Prestamo(Date fecha, boolean devuelto, Libros libro, Socio socio) {
	super();
	this.fecha = fecha;
	this.devuelto = devuelto;
	this.libro = libro;
	this.socio = socio;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public boolean isDevuelto() {
	return devuelto;
}
public void setDevuelto(boolean devuelto) {
	this.devuelto = devuelto;
}
public Libros getLibro() {
	return libro;
}
public void setLibro(Libros libro) {
	this.libro = libro;
}
public Socio getSocio() {
	return socio;
}
public void setSocio(Socio socio) {
	this.socio = socio;
}

}
