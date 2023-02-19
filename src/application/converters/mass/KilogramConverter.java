package application.converters.mass;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class KilogramConverter extends BaseUnitConverter {

	public KilogramConverter() {
		this.MULTIPLIER = new BigDecimal(1);
	}
	
	@Override
	public String getName() {
		return "Kilograms";
	}
	
}