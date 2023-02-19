package application.converters.time;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class YearConverter extends BaseUnitConverter {
	
	public YearConverter() {
		this.MULTIPLIER = new BigDecimal(31536000);
	}
	
	@Override
	public String getName() {
		return "Years";
	}

}
