package application.converters.length;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class FootConverter extends BaseUnitConverter{

	public FootConverter() {
		// Conversion factor with respect to base unit (meters)
		this.MULTIPLIER = new BigDecimal(0.3048);
	}
	
	@Override
	public String getName() {
		return "Foot";
	}
	
}
