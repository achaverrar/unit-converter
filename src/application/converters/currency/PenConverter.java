package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class PenConverter extends BaseUnitConverter {

	public PenConverter() {
		this.MULTIPLIER = new BigDecimal(1280.19);
	}
	
	public PenConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Peruvian Soles";
	}

}
