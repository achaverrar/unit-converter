package application.converters.temperature;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class CelsiusConverter extends BaseUnitConverter{
	public CelsiusConverter () {
		this.MULTIPLIER = new BigDecimal(1);
	}

	@Override
	public String getName() {
		return "Celsius";
	}
	
}
