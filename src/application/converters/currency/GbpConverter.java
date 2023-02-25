package application.converters.currency;

import java.math.BigDecimal;

public class GbpConverter extends CurrencyUnitConverter {

	public GbpConverter() {
		this.MULTIPLIER = new BigDecimal(0.00017);
	}
	
	@Override
	public String getName() {
		return "British Pounds";
	}


	@Override
	public String getCurrencyCode() {
		return "GBP";
	}
	
}
