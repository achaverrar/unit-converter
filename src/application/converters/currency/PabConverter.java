package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class PabConverter extends BaseUnitConverter {

	public PabConverter() {
		this.MULTIPLIER = new BigDecimal(4930.16);
	}
	
	public PabConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Panamanian Balboas";
	}

}
