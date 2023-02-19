package application.converters.time;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MonthConverter extends BaseUnitConverter {
	
	public MonthConverter() {
		this.MULTIPLIER = new BigDecimal(2628000);
	}
	
	@Override
	public String getName() {
		return "Months";
	}

}
