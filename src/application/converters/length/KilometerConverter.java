package application.converters.length;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class KilometerConverter extends BaseUnitConverter{

	public KilometerConverter() {
		this.MULTIPLIER = new BigDecimal(1000);
	}
	
	@Override
	public String getName() {
		return "Kilometer";
	}
	
}
