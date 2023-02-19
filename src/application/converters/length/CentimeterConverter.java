package application.converters.length;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class CentimeterConverter extends BaseUnitConverter{

	public CentimeterConverter() {
		this.MULTIPLIER = new BigDecimal(0.01);
	}
	
	@Override
	public String getName() {
		return "Centimeters";
	}
	
}
