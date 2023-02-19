package application.converters.time;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class HourConverter extends BaseUnitConverter {

	public HourConverter() {
		this.MULTIPLIER = new BigDecimal(3600);
	}
	
	@Override
	public String getName() {
		return "Hours";
	}

}
