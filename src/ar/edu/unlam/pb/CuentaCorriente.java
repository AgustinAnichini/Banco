package ar.edu.unlam.pb;

public class CuentaCorriente extends Cuenta {

	private final double DESCUBIERTO_MAXIMO = 150.0;
	private final double SIN_DEUDA = 0.0;
	private double descubiertoActual;
	private Double leDeboAlBanco;
	// el bna nos da la posibilidad de retirar mas dinero del que tenemos siempre y
	// cuando no superer el EXTRACCION_ADICIONAL
    //pero nos cobra el adicional que usamos mas un 5% del dinero otorgado por el banco

	public CuentaCorriente(Integer numeroCuenta, Cliente Cliente) {
		super(numeroCuenta, Cliente);
		this.leDeboAlBanco = 0.0;
		this.descubiertoActual = 0.0;
	}

	@Override
	public boolean retirar(Double montoARetirar) {
		Double cincoPorcientoDeloUtilizado = 0.0;
		boolean sePudoRetirar = false;
		
		if (super.retirar(montoARetirar)) {
			sePudoRetirar = true;
		} else {
			descubiertoActual = montoARetirar - this.getSaldo();
			if (descubiertoActual <= DESCUBIERTO_MAXIMO) {
				cincoPorcientoDeloUtilizado = (5.0 / 100.0) * descubiertoActual;
				leDeboAlBanco = descubiertoActual + cincoPorcientoDeloUtilizado;
				this.depositar(descubiertoActual);
				super.retirar(montoARetirar);
				sePudoRetirar = true;
			}
		}
		return sePudoRetirar;
	}
	@Override
	public void depositar(Double deposito) {
		if (leDeboAlBanco.equals(SIN_DEUDA)) {
			super.depositar(deposito);
		} else {
			super.depositar(deposito);
			if (super.getSaldo() <= leDeboAlBanco) {
				// deposito 100, mi deuda es 105, el banco tiene que sacarme 100 y dejar
				// debiendo 5
				super.retirar(leDeboAlBanco);
			}
		}
	}

	public double getDescubiertoActual() {
		return descubiertoActual;
	}

	public void setDescubiertoActual(double descubiertoActual) {
		this.descubiertoActual = descubiertoActual;
	}

	public Double getLeDeboAlBanco() {
		return leDeboAlBanco;
	}

	public void setLeDeboAlBanco(Double leDeboAlBanco) {
		this.leDeboAlBanco = leDeboAlBanco;
	}

	public double getDESCUBIERTO_MAXIMO() {
		return DESCUBIERTO_MAXIMO;
	}

}
