package application.converters.mass;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class GramConverter extends BaseUnitConverter {

	public GramConverter() {
		this.MULTIPLIER = new BigDecimal(0.001);
	}
	
	@Override
	public String getName() {
		return "Grams";
	}
	
}