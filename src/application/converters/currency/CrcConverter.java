package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class CrcConverter extends BaseUnitConverter {

	public CrcConverter() {
		this.MULTIPLIER = new BigDecimal(8.82);
	}
	
	public CrcConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Costa Rican Colons";
	}

}
