package application.converters.temperature;

import java.math.BigDecimal;
import java.math.RoundingMode;

import application.converters.BaseUnitConverter;

public class FahrenheitConverter extends BaseUnitConverter {

	private static final BigDecimal _9_5 = new BigDecimal(1.8);
	private static final BigDecimal _5_9 = new BigDecimal(0.555556);
	private static final BigDecimal _32 = new BigDecimal(32);
	
	@Override
	public BigDecimal convertToBase(BigDecimal value) {
		return value.subtract(_32).multiply(_5_9).setScale(4, RoundingMode.HALF_UP);
	}
	
	@Override
	public BigDecimal convertFromBase(BigDecimal value) {
		return value.multiply(_9_5).add(_32).setScale(4, RoundingMode.HALF_UP);
	}
	
	@Override
	public String getName() {
		return "Fahrenheit";
	}
	
}
