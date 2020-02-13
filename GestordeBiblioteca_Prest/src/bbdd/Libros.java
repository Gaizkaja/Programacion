package bbdd;


public class Libros {
private int id;
private String titulo;
private String autor;
private int numPags;

public Libros() {
	super();
}
public Libros(int id, String titulo, String autor, int numPags) {
	super();
	this.id = id;
	this.titulo = titulo;
	this.autor = autor;
	this.numPags = numPags;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getAutor() {
	return autor;
}
public void setAutor(String autor) {
	this.autor = autor;
}
public int getNumPags() {
	return numPags;
}
public void setNumPags(int numPags) {
	this.numPags = numPags;
}

@Override
public String toString() {
	return "Libros [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", numPags=" + numPags + "]";
}

}
