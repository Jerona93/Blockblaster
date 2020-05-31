package beans;

public class User {
	
	int id;
	String user;
	String password;
	public int saldo;
	public int telefono;
	public int PelisAlquiladas;
	
	public User() {}
	public User(int id, String user, String password, int saldo, int telefono, int PelisAlquiladas) {
		this.id = id;
		this.user = user;
		this.password = password;
		this.saldo = saldo;
		this.telefono = telefono;
		this.PelisAlquiladas = PelisAlquiladas;
	}
	
	public int getPelisAlquiladas() {
		return PelisAlquiladas;
	}
	public void setPelisAlquiladas(int pelisAlquiladas) {
		PelisAlquiladas = pelisAlquiladas;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


}
