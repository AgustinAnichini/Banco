package ar.edu.unlam.pb;

import java.util.Objects;

public class Cliente {

	private String nombre;
	private String email;
	private Integer cuil;
	private String password;

	public Cliente(String nombre, String email, Integer cuil, String password) {
		this.nombre = nombre;
		this.email = email;
		this.cuil = cuil;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCuil() {
		return cuil;
	}

	public void setCuil(Integer cuil) {
		this.cuil = cuil;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cuil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cuil, other.cuil);
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", email=" + email + ", cuil=" + cuil + ", password=" + password + "]";
	}

}
