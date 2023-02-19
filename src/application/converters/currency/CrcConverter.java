package application.converters.currency;

import java.math.BigDecimal;

public class CrcConverter extends CurrencyUnitConverter {

	public CrcConverter() {
		this.MULTIPLIER = new BigDecimal(0.117);
	}
	
	public CrcConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Costa Rican Colons";
	}

}
