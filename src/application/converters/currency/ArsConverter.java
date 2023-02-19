package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class ArsConverter extends BaseUnitConverter {

	public ArsConverter() {
		this.MULTIPLIER = new BigDecimal(25.35);
	}
	
	public ArsConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Argentine Pesos";
	}

}
