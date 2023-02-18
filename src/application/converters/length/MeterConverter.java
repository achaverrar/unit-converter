package application.converters.length;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MeterConverter extends BaseUnitConverter{

	public MeterConverter() {
		this.MULTIPLIER = new BigDecimal(1);
	}
	
	@Override
	public String getName() {
		return "Meter";
	}
	
}
