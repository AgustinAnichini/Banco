package ar.edu.unlam.pb;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasosDePrueba {

	@Test
	public void queSePuedaCrearUnaCuenta() {
		// datos de entrada
		Cuenta nuevaCuenta;
		Cliente nuevoCliente;

		String nombreCliente = "Agustin";
		String email = "agustinAnichini277@gmail.com";
		Integer cuil = 2045985905;
		String password = "TATOcapo12";
		
		final Integer numeroCuenta = 1000;
		// ejecucion

		nuevoCliente = new Cliente(nombreCliente, email, cuil, password);
		nuevaCuenta = new CuentaSueldo(numeroCuenta, nuevoCliente);
		// validacion
		assertNotNull(nuevoCliente);
		assertNotNull(nuevaCuenta);
	}

	@Test
	public void queSePuedaDepositarYRetirarDineroEnUnaCuenta() {
		// datos de entrada
		Cuenta nuevaCuenta;
		Cliente nuevoCliente;

		String nombreCliente = "Agustin";
		String email = "agustinAnichini277@gmail.com";
		Integer cuil = 2045985905;
		String password = "TATOcapo12";
		final Integer numeroCuenta = 1000;
		final Double saldoInicial = 500.0;
		Double dineroADepositar = 500.0;
		Double dineroARetirar = 500.0;
		Double saldoEsperado = 500.0;
		// ejecucion

		nuevoCliente = new Cliente(nombreCliente, email, cuil, password);
		nuevaCuenta = new CuentaSueldo(numeroCuenta, nuevoCliente);
		nuevaCuenta.depositar(saldoInicial);
		nuevaCuenta.depositar(dineroADepositar);
		nuevaCuenta.retirar(dineroARetirar);
		// validacion

		assertNotNull(nuevoCliente);
		assertNotNull(nuevaCuenta);
		assertEquals(saldoEsperado, nuevaCuenta.getSaldo());
	}

	@Test
	public void queSePuedaCrearUnBanco() {
		// datos de entrada

		Banco bna;
		String nombreBanco = "Banco de la Nacion Argentina";
		// ejecucion

		bna = new Banco(nombreBanco); // Sin cuentas inicialmente porque no solo hace eso
		// Validacion

		assertNotNull(bna);
	}

	@Test
	public void queSePuedaAgregarUnaCuentaAlBanco() {
		// datos de entrada
		Cuenta nuevaCuenta;
		Cliente nuevoCliente;
		Banco bna;

		String nombreBanco = "Banco de la Nacion Argentina";
		String nombreCliente = "Agustin";
		String email = "agustinAnichini277@gmail.com";
		Integer cuil = 2045985905;
		String password = "TATOcapo12";
		final Integer numeroCuenta = 1000;
		final Double saldoInicial = 500.0;
		Double dineroADepositar = 500.0;
		Double saldoEsperado = saldoInicial + dineroADepositar;
		final Integer CANTIDAD_DE_CUENTAS_ESPERADAS = 1;
//		Boolean seAgrego = false;
		// ejecucion

		nuevoCliente = new Cliente(nombreCliente, email, cuil, password);
		nuevaCuenta = new CuentaSueldo(numeroCuenta, nuevoCliente);
		bna = new Banco(nombreBanco);
		bna.agregarCuenta(nuevaCuenta);

		nuevaCuenta.depositar(saldoInicial);
		nuevaCuenta.depositar(dineroADepositar);
		// validacion

		assertNotNull(nuevoCliente);
		assertNotNull(nuevaCuenta);
		assertNotNull(bna);
//		assertTrue(seAgrego);
		assertEquals(CANTIDAD_DE_CUENTAS_ESPERADAS, bna.getCantidadCuentas());
		assertEquals(saldoEsperado, nuevaCuenta.getSaldo());
	}

	@Test
	public void queNoSePuedanAgregarDosCuentasConElMismoNumero() {
		// datos de entrada
		Cuenta cuentaMil, otraCuentaMil;
		Cliente nuevoCliente;
		Banco bna;

		final Integer numeroCuentaMil = 1000;
		final Integer numeroCuentaOtraMil = 1000;
		String nombreBanco = "Banco de la Nacion Argentina";
		String nombreCliente = "Agustin";
		String email = "agustinAnichini277@gmail.com";
		Integer cuil = 2045985905;
		String password = "TATOcapo12";
		final Integer CANTIDAD_DE_CUENTAS_ESPERADAS = 1;
		// ejecucion

		nuevoCliente = new Cliente(nombreCliente, email, cuil, password);
		cuentaMil = new CuentaSueldo(numeroCuentaMil, nuevoCliente);
		otraCuentaMil = new CuentaSueldo(numeroCuentaOtraMil, nuevoCliente);
		bna = new Banco(nombreBanco);
		bna.agregarCuenta(cuentaMil);
		bna.agregarCuenta(otraCuentaMil);
		// validacion

		assertNotNull(nuevoCliente);
		assertNotNull(cuentaMil);
		assertNotNull(otraCuentaMil);
		assertNotNull(bna);
		assertEquals(CANTIDAD_DE_CUENTAS_ESPERADAS, bna.getCantidadCuentas());
	}

	@Test
	public void queSePuedaCrearUnaCuentaAdolescenteYSuSalgoInicialSea500() {
		// Preparacion
		CuentaAdolescente cuentaMiSobrina;
		Cliente miSobrina;
		// Ejecucion
		final Integer numeroCuentaMil = 1000;
		final Double SALDO_ESPERADO = 500.0;
		String nombreCliente = "Delfina";
		String email = "delfina@gmail.com";
		Integer cuil = 2045985905;
		String password = "TATOcapo12";
		miSobrina = new Cliente(nombreCliente, email, cuil, password);
		cuentaMiSobrina = new CuentaAdolescente(numeroCuentaMil, miSobrina);
		// validacion
		assertNotNull(cuentaMiSobrina);
		assertEquals(SALDO_ESPERADO, cuentaMiSobrina.getSaldo());

	}

	@Test
	public void queSePuedaCrearUnaCuentaSueldo() {
		// Preparacion
		CuentaSueldo nuevaCuentaSueldo;
		Cliente empleado;
		Banco bna;

		// Ejecucion
		String nombreBanco = "Banco de la Nacion Argentina";
		final Integer numeroCuentaMil = 1000;
		Double SALDO_ESPERADO = 4000.0;
		String nombreCliente = "Agustin";
		String email = "Agustin@gmail.com";
		Integer cuil = 2045985905;
		String password = "TATOcapo12";
		empleado = new Cliente(nombreCliente, email, cuil, password);
		nuevaCuentaSueldo = new CuentaSueldo(numeroCuentaMil, empleado);
		bna = new Banco(nombreBanco);
		bna.agregarCuenta(nuevaCuentaSueldo);
		nuevaCuentaSueldo.depositar(5000.0);
		nuevaCuentaSueldo.retirar(1000.0);
		// validacion
		assertNotNull(nuevaCuentaSueldo);
		assertEquals(SALDO_ESPERADO, nuevaCuentaSueldo.getSaldo());

	}

	@Test
	public void queSePuedaCrearUnaCajaDeAhorro() {
		// Preparacion
		CajaDeAhorro nuevaCajaDeAhorro;
		Cliente ahorrador;
		Banco bna;

		// Ejecucion
		String nombreBanco = "Banco de la Nacion Argentina";
		final Integer numeroCuentaMil = 1000;
		Double SALDO_ESPERADO = 976.0;
		String nombreCliente = "Agustin";
		String email = "Agustin@gmail.com";
		Integer cuil = 2045985905;
		String password = "TATOcapo12";
		ahorrador = new Cliente(nombreCliente, email, cuil, password);
		nuevaCajaDeAhorro = new CajaDeAhorro(numeroCuentaMil, ahorrador);
		bna = new Banco(nombreBanco);
		bna.agregarCuenta(nuevaCajaDeAhorro);
		nuevaCajaDeAhorro.depositar(5000.0);
		for (int i = 0; i < 8; i++) {
			nuevaCajaDeAhorro.retirar(500.0);
		}
		// validacion
		assertNotNull(nuevaCajaDeAhorro);
		assertEquals(SALDO_ESPERADO, nuevaCajaDeAhorro.getSaldo());

	}

	@Test
	public void queSePuedaCrearUnaCuentaCorriente() {
		// Preparacion
		CuentaCorriente nuevaCuentaCorriente;
		Cliente empleado;
		Banco bna;

		// Ejecucion
		String nombreBanco = "Banco de la Nacion Argentina";
		final Integer numeroCuentaMil = 1000;
		Double SALDO_ESPERADO = 4000.0;
		String nombreCliente = "Agustin";
		String email = "Agustin@gmail.com";
		Integer cuil = 2045985905;
		String password = "TATOcapo12";
		empleado = new Cliente(nombreCliente, email, cuil, password);
		nuevaCuentaCorriente = new CuentaCorriente(numeroCuentaMil, empleado);
		bna = new Banco(nombreBanco);
		bna.agregarCuenta(nuevaCuentaCorriente);
		nuevaCuentaCorriente.depositar(SALDO_ESPERADO);

		// validacion
		assertNotNull(nuevaCuentaCorriente);
		assertEquals(SALDO_ESPERADO, nuevaCuentaCorriente.getSaldo());

	}

//     ESTOS NO FUNCIONAN
	@Test
	public void queSeCobreCincoPorcientoDeComisionAlDepositarDineroLuegoDeHaberRealizadoUnaExtraccionMayorAlSaldo() {
		// Preparacion
		CuentaCorriente nuevaCuentaCorriente;
		Cliente empleado;
		Banco bna;

		// Ejecucion
		String nombreBanco = "Banco de la Nacion Argentina";
		final Integer numeroCuentaMil = 1000;
		String nombreCliente = "Agustin";
		String email = "Agustin@gmail.com";
		Integer cuil = 2045985905;
		String password = "TATOcapo12";

		Double SALDO_ESPERADO = 95.0;
		Double primerDeposito = 100.0;
		Double montoARetirar = 200.0;
		Double segundoDeposito = 200.0;
		Double leDeboAlBancoEsperado = 105.0;
		empleado = new Cliente(nombreCliente, email, cuil, password);
		nuevaCuentaCorriente = new CuentaCorriente(numeroCuentaMil, empleado);
		bna = new Banco(nombreBanco);

		bna.agregarCuenta(nuevaCuentaCorriente);
		nuevaCuentaCorriente.depositar(primerDeposito);
		nuevaCuentaCorriente.getSaldo();
		nuevaCuentaCorriente.retirar(montoARetirar);
		nuevaCuentaCorriente.getSaldo();// tengo que tener saldo 0
		nuevaCuentaCorriente.depositar(segundoDeposito);

		// validacion
		assertNotNull(nuevaCuentaCorriente);
		assertEquals(SALDO_ESPERADO, nuevaCuentaCorriente.getSaldo());
		assertEquals(leDeboAlBancoEsperado, nuevaCuentaCorriente.getLeDeboAlBanco());

	}

	@Test
	public void queSeCobreCincoPorcientoDeComisionPorMasQueElProximoDepositoNoSeaSuficienteParaCubrirElDescubierto() {
		// Preparacion
		CuentaCorriente nuevaCuentaCorriente;
		Cliente empleado;
		Banco bna;

		// Ejecucion
		String nombreBanco = "Banco de la Nacion Argentina";
		final Integer numeroCuentaMil = 1000;
		String nombreCliente = "Agustin";
		String email = "Agustin@gmail.com";
		Integer cuil = 2045985905;
		String password = "TATOcapo12";

		Double SALDO_ESPERADO = 0.0;
		Double deposito = 100.0;
		Double montoARetirar = 200.0;
		Double depositoX2 = 100.0;
		Double leDeboAlBancoEsperado = 0.0;
		double descubiertoActual = 5.0;

		empleado = new Cliente(nombreCliente, email, cuil, password);
		nuevaCuentaCorriente = new CuentaCorriente(numeroCuentaMil, empleado);
		bna = new Banco(nombreBanco);
		bna.agregarCuenta(nuevaCuentaCorriente);

		nuevaCuentaCorriente.depositar(deposito);
		nuevaCuentaCorriente.retirar(montoARetirar);

		nuevaCuentaCorriente.depositar(depositoX2);

		// validacion
		assertNotNull(nuevaCuentaCorriente);
		assertEquals(SALDO_ESPERADO, nuevaCuentaCorriente.getSaldo());
		assertEquals(descubiertoActual, nuevaCuentaCorriente.getDescubiertoActual());
		assertEquals(leDeboAlBancoEsperado, nuevaCuentaCorriente.getLeDeboAlBanco());

	}
}
