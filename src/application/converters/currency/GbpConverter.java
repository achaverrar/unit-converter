package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class GbpConverter extends BaseUnitConverter {

	public GbpConverter() {
		this.MULTIPLIER = new BigDecimal(5881.19);
	}
	
	public GbpConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "British Pounds";
	}

}
