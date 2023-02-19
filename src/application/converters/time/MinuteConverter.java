package application.converters.time;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MinuteConverter extends BaseUnitConverter {

	public MinuteConverter() {
		this.MULTIPLIER = new BigDecimal(60);
	}
	
	@Override
	public String getName() {
		return "Minutes";
	}

}
