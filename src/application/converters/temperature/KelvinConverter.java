package application.converters.temperature;

import java.math.BigDecimal;
import java.math.RoundingMode;

import application.converters.BaseUnitConverter;

public class KelvinConverter extends BaseUnitConverter{
	
	private static final BigDecimal KELVIN_CONSTANT = new BigDecimal(273.15);
	
	@Override
	public BigDecimal convertToBase(BigDecimal value) {
		return value.subtract(KELVIN_CONSTANT).setScale(4, RoundingMode.HALF_UP);
	}
	
	@Override
	public BigDecimal convertFromBase(BigDecimal value) {
		return value.add(KELVIN_CONSTANT).setScale(4, RoundingMode.HALF_UP);
	}

	@Override
	public String getName() {
		return "Kelvin";
	}
}
