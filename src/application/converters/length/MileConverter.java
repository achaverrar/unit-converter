package application.converters.length;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MileConverter extends BaseUnitConverter{

	public MileConverter() {
		this.MULTIPLIER = new BigDecimal(1609.344);
	}
	
	@Override
	public String getName() {
		return "Miles";
	}
	
}
