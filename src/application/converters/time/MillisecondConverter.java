package application.converters.time;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MillisecondConverter extends BaseUnitConverter {

	public MillisecondConverter() {
		this.MULTIPLIER = new BigDecimal(0.001);
	}
	
	@Override
	public String getName() {
		return "Milliseconds";
	}

}
