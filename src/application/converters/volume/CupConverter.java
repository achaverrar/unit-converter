package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class CupConverter extends BaseUnitConverter{

	public CupConverter() {
		this.MULTIPLIER = new BigDecimal(0.24);
	}
	
	@Override
	public String getName() {
		return "Cups";
	}
	
}
