package beans;

public class alquiler {
	int Num_alquiler;
	String Fecha_out;
	String Fecha_in;;
	public int id_usuario;
	public int id_peli;
	
	public alquiler() {}
	public alquiler(int Num_alquiler, String Fecha_out, String Fecha_in, int id_usuario, int id_peli) {
		this.Num_alquiler = Num_alquiler;
		this.Fecha_out = Fecha_out;
		this.Fecha_in = Fecha_in;
		this.id_usuario = id_usuario;
		this.id_peli = id_peli;
	}
	public int getNum_alquiler() {
		return Num_alquiler;
	}
	public void setNum_alquiler(int num_alquiler) {
		Num_alquiler = num_alquiler;
	}
	public String getFecha_out() {
		return Fecha_out;
	}
	public void setFecha_out(String fecha_out) {
		Fecha_out = fecha_out;
	}
	public String getFecha_in() {
		return Fecha_in;
	}
	public void setFecha_in(String fecha_in) {
		Fecha_in = fecha_in;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_peli() {
		return id_peli;
	}
	public void setId_peli(int id_peli) {
		this.id_peli = id_peli;
	}
}
