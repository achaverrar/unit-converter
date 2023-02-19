package application.converters.mass;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class PoundConverter extends BaseUnitConverter {

	public PoundConverter() {
		this.MULTIPLIER = new BigDecimal(0.453592);
	}
		
	@Override
	public String getName() {
		return "Pounds";
	}

}
