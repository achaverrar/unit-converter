package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class LiterConverter extends BaseUnitConverter{

	public LiterConverter() {
		this.MULTIPLIER = new BigDecimal(1);
	}
	
	@Override
	public String getName() {
		return "Liter";
	}
	
}
