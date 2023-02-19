package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class SvcConverter extends BaseUnitConverter {

	public SvcConverter() {
		this.MULTIPLIER = new BigDecimal(563.50);
	}
	
	public SvcConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Salvadoran Colons";
	}

}
