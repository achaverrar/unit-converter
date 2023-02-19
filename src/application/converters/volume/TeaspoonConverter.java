package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class TeaspoonConverter extends BaseUnitConverter{

	public TeaspoonConverter() {
		this.MULTIPLIER = new BigDecimal(0.00492892);
	}
	
	@Override
	public String getName() {
		return "Teaspoons";
	}
	
}
