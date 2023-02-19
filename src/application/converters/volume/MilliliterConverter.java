package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MilliliterConverter extends BaseUnitConverter{

	public MilliliterConverter() {
		this.MULTIPLIER = new BigDecimal(0.001);
	}
	
	@Override
	public String getName() {
		return "Milliliters";
	}
	
}
