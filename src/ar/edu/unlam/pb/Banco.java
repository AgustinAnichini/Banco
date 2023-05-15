package ar.edu.unlam.pb;

import java.util.HashSet;

public class Banco {

	private String nombre;
	private HashSet<Cuenta> cuentas;

	public Banco(String nombre) {
		this.nombre = nombre;
		this.cuentas = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean agregarCuenta(Cuenta nuevaCuenta) {
		return cuentas.add(nuevaCuenta);
	}

	public Integer getCantidadCuentas() {
		return cuentas.size();
	}

	@Override
	public String toString() {
		return "Banco Nombre=" + nombre + ", Cuentas=" + cuentas + "]";
	}

}
