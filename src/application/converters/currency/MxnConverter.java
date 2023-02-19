package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MxnConverter extends BaseUnitConverter {

	public MxnConverter() {
		this.MULTIPLIER = new BigDecimal(265.95);
	}
	
	public MxnConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Mexican Pesos";
	}

}
