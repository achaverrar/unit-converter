package application.converters.time;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class DayConverter extends BaseUnitConverter {

	public DayConverter() {
		this.MULTIPLIER = new BigDecimal(86400);
	}
	
	@Override
	public String getName() {
		return "Days";
	}

}
