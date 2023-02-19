package application.converters.speed;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MphConverter extends BaseUnitConverter {

	public MphConverter() {
		this.MULTIPLIER = new BigDecimal(0.44704);
	}
	
	@Override
	public String getName() {
		return "Miles / Hour";
	}

}
