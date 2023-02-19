package application.converters.length;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MillimeterConverter extends BaseUnitConverter{

	public MillimeterConverter() {
		this.MULTIPLIER = new BigDecimal(0.001);
	}
	
	@Override
	public String getName() {
		return "Millimeters";
	}
	
}
