package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class PintConverter extends BaseUnitConverter{

	public PintConverter() {
		this.MULTIPLIER = new BigDecimal(0.473176);
	}
	
	@Override
	public String getName() {
		return "Pints";
	}
	
}
