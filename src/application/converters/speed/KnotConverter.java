package application.converters.speed;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class KnotConverter extends BaseUnitConverter {

	public KnotConverter() {
		this.MULTIPLIER = new BigDecimal(0.514444);
	}
	
	@Override
	public String getName() {
		return "Knots";
	}

}
