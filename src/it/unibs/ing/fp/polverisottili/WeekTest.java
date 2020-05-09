package it.unibs.ing.fp.polverisottili;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WeekTest {
	private static final double[] VALUES_UNDER_STANDARTS = {30, 30, 30, 30, 30, 30, 30};
	private static final double[] VALUES_OVER_STANDARTS = {100, 100, 100, 100, 100, 100, 100};
	private static final double[] VALUES_MAX_ONLY_OVER_STANDARTS = {10, 10, 10, 10, 10, 10, 100};
	private static final double[] VALUES_AVERAGE_ONLY_OVER_STANDARTS = {60, 60, 60, 60, 60, 60, 60};
	
	/**
	 * controlla che con i valori tutti sotto media o il massimo, gli indicatori devono essere true
	 */
	@Test
	public void testNoAllarms() {
		Week week = new Week(2020, 1);
		week.setDayValue(VALUES_UNDER_STANDARTS);
		assertTrue(week.maxNotExceeded());
		assertTrue(week.averageNotExceeded());
	}
	
	/**
	 * valori alti sia sopra media che sopra il massimo, gli indicatori devono essere false
	 */
	@Test
	public void testAllAllarms() {
		Week week = new Week(2020, 1);
		week.setDayValue(VALUES_OVER_STANDARTS);
		assertFalse(week.maxNotExceeded());
		assertFalse(week.averageNotExceeded());
	}
	
	/**
	 * deve diventare false solo l'indicatore del massimo
	 */
	@Test
	public void testMaxOnlyAllarm() {
		Week week = new Week(2020, 1);
		week.setDayValue(VALUES_MAX_ONLY_OVER_STANDARTS);
		assertFalse(week.maxNotExceeded());
		assertTrue(week.averageNotExceeded());
	}
	
	/**
	 * deve diventare false solo l'indicatore della media
	 */
	@Test
	public void testAverageOnlyAllarm() {
		Week week = new Week(2020, 1);
		week.setDayValue(VALUES_AVERAGE_ONLY_OVER_STANDARTS);
		assertTrue(week.maxNotExceeded());
		assertFalse(week.averageNotExceeded());
	}

}
