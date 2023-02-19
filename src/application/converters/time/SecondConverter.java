package application.converters.time;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class SecondConverter extends BaseUnitConverter {
	
	public SecondConverter() {
		this.MULTIPLIER = new BigDecimal(1);
	}
	
	@Override
	public String getName() {
		return "Seconds";
	}

}
