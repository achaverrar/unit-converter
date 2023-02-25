package application.converters.currency;

import java.math.BigDecimal;

public class CrcConverter extends CurrencyUnitConverter {

	public CrcConverter() {
		this.MULTIPLIER = new BigDecimal(0.117);
	}
	
	@Override
	public String getName() {
		return "Costa Rican Colons";
	}
	
	@Override
	public String getCurrencyCode() {
		return "CRC";
	}

}
