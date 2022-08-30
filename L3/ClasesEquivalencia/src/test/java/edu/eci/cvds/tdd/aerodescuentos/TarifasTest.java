package edu.eci.cvds.tdd.aerodescuentos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TarifasTest {
	private double tarifaBaseValid = 100000;

	@Test
	void shouldGenerateExeptionInvalidTarifaBase() {
		//assertThrows(Exception.class,CalculadorDescuentos.calculoTarifa(-1, 0, 0));
		try {
			double tarifa = CalculadorDescuentos.calculoTarifa(-1, 0, 0);
			assertTrue(false);
		}catch( Exception e) {
			assertTrue(true);
		}
	}


	@Test
	void shouldGenerateExeptionInvalidEdad() {
		//assertThrows(Exception.class,CalculadorDescuentos.calculoTarifa(tarifaBaseValid, 0, -1));
		try {
		double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBaseValid, 0, -1);
		assertTrue(false);
		}catch( Exception e) {
			assertTrue(true);
		}
	}

	
	@Test
	void shouldGenerateExeptionInvalidDiasA() {
		//assertThrows(Exception.class,CalculadorDescuentos.calculoTarifa(tarifaBaseValid, -1, 19));
		try {
		double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBaseValid, -1, 19);
		assertTrue(false);
		}catch( Exception e) {
			assertTrue(true);
		}
	}
	
	
	@Test
	void shouldNotGenerateAnyOffer() {
		double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBaseValid, 10, 20);
		assertTrue(tarifa == tarifaBaseValid);
	}
	
	@Test
	void shouldGenerateOfferPerDays() {
		double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBaseValid, 21, 18);
		assertTrue(tarifa == 85000);
	}
	
	@Test
	void shouldGenerateOfferPerDaysAndLowAge() {
		double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBaseValid, 21, 17);
		assertTrue(tarifa == 80000);
	}

	@Test
	void shouldGenerateOfferPerDaysAndHighAge() {
		double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBaseValid, 21, 66);
		assertTrue(tarifa == 77000);
	}
	
	@Test
	void shouldGenerateOfferPerLowAge() {
		double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBaseValid, 20, 17);
		assertTrue(tarifa == 95000);
	}

	@Test
	void shouldGenerateOfferPerHighAge() {
		double tarifa = CalculadorDescuentos.calculoTarifa(tarifaBaseValid, 20, 66);
		assertTrue(tarifa == 92000);
	}
}
