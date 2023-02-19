package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class KrwConverter extends BaseUnitConverter {

	public KrwConverter() {
		this.MULTIPLIER = new BigDecimal(3.77);
	}
	
	public KrwConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "South Korean Wons";
	}

}
