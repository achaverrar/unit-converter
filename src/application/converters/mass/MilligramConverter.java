package application.converters.mass;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MilligramConverter extends BaseUnitConverter {

	public MilligramConverter() {
		this.MULTIPLIER = new BigDecimal(0.000001);
	}
	
	@Override
	public String getName() {
		return "Milligrams";
	}
	
}