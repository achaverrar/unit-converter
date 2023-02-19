package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class DopConverter extends BaseUnitConverter {

	public DopConverter() {
		this.MULTIPLIER = new BigDecimal(87.97);
	}
	
	public DopConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Dominican Pesos";
	}

}
