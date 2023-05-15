package ar.edu.unlam.pb;

public class CajaDeAhorro extends Cuenta {

	private Integer contadorExtracciones;
	private final int LIMITE_DE_EXTRACCIONES = 5;

	private final double COSTO_ADICIONAL = 6.0;

	public CajaDeAhorro(Integer numeroCuenta, Cliente Cliente) {
//		super(numeroCuenta, Cliente);
		this.contadorExtracciones = 0;
	}

	@Override
	public boolean retirar(Double dineroARetirar) {
		boolean sePudoRetirar = false;
		if (super.getSaldo() >= dineroARetirar) {
			super.retirar(dineroARetirar);
			contadorExtracciones++;
			sePudoRetirar = true;
		}
		if (contadorExtracciones >= LIMITE_DE_EXTRACCIONES) {
			super.retirar(COSTO_ADICIONAL);
		}
		return sePudoRetirar;
	}

	public Integer getContadorExtracciones() {
		return contadorExtracciones;
	}

	public void setContadorExtracciones(Integer contadorExtracciones) {
		this.contadorExtracciones = contadorExtracciones;
	}

	public int getLIMITE_DE_EXTRACCIONES() {
		return LIMITE_DE_EXTRACCIONES;
	}

	public double getCOSTO_ADICIONAL() {
		return COSTO_ADICIONAL;
	}
}
