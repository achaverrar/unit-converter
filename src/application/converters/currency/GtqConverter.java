package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class GtqConverter extends BaseUnitConverter {

	public GtqConverter() {
		this.MULTIPLIER = new BigDecimal(630.03);
	}
	
	public GtqConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Guatemalan Quetzals";
	}

}
