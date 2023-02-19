package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class ClpConverter extends BaseUnitConverter {

	public ClpConverter() {
		this.MULTIPLIER = new BigDecimal(6.16);
	}
	
	public ClpConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Chilean Pesos";
	}

}
