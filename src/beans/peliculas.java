package beans;

public class peliculas {
	String titulo;
	int duracion;;
	public int año;
	public int id_peli;
	
	public peliculas() {}
	public peliculas(String titulo, int duracion, int año, int id_peli) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.año = año;
		this.id_peli = id_peli;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public int getId_peli() {
		return id_peli;
	}
	public void setId_peli(int id_peli) {
		this.id_peli = id_peli;
	}
}
