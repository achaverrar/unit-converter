package application.converters.currency;

import java.math.BigDecimal;

public class EurConverter extends CurrencyUnitConverter {

	public EurConverter() {
		this.MULTIPLIER = new BigDecimal(0.000192);
	}

	@Override
	public String getName() {
		return "Euros";
	}
	
	@Override
	public String getCurrencyCode() {
		return "EUR";
	}
	
}
