package ar.edu.unlam.pb;

import java.util.Objects;

public abstract class Cuenta {

	private Integer numeroCuenta;
	private Cliente cliente;
	private Double saldo;

	public Cuenta(Integer numeroCuenta, Cliente Cliente) {
		this.numeroCuenta = numeroCuenta;
		this.cliente = Cliente;
		this.saldo = 0.0;
	}

	public Cuenta() {
		this.saldo = 0.0;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void depositar(Double dineroADepositar) {
		this.saldo += dineroADepositar;
	}

	public boolean retirar(Double dineroARetirar) {
		boolean sePudoRetirar = false;
		if (this.saldo >= dineroARetirar) {
			this.saldo -= dineroARetirar;
			sePudoRetirar = true;
		}
		return sePudoRetirar;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(numeroCuenta, other.numeroCuenta);
	}

	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}

}
