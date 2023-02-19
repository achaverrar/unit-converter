package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class EurConverter extends BaseUnitConverter {

	public EurConverter() {
		this.MULTIPLIER = new BigDecimal(5232.96);
	}
	
	public EurConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Euros";
	}

}
