package ar.edu.unlam.pb;

public class CuentaAdolescente extends Cuenta {

	private final Double SALDO_INICIAL = 500.0;
//	private Double saldo = 0.0; -->> ya tengo este atributo en Cuenta

	public CuentaAdolescente(Integer numero, Cliente cliente) {
		/*
		 * this.saldo = SALDO_INICIAL; La primera instruccion de todo constructor, es la
		 * llamada al constructor de la clase padre. para tener a disposicion en memoria
		 * toda la info. asociada al padre
		 */
		super(numero, cliente);// --> la llamada explicita al constructor del padre
		setSaldo(SALDO_INICIAL);
// Otra opcion:
//		setNumeroCuenta(numero);
//		setCliente(cliente);
//		setSaldo(SALDO_INICIAL);
	}
}
