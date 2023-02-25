package application.converters.currency;

import java.math.BigDecimal;

public class JpyConverter extends CurrencyUnitConverter {

	public JpyConverter() {
		this.MULTIPLIER = new BigDecimal(0.0275);
	}

	@Override
	public String getName() {
		return "Japanese Yens";
	}

	@Override
	public String getCurrencyCode() {
		return "JPY";
	}
	
}
