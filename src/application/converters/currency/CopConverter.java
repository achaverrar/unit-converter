package application.converters.currency;

import java.math.BigDecimal;

public class CopConverter extends CurrencyUnitConverter {

	public CopConverter() {
		this.MULTIPLIER = new BigDecimal(1);
	}
	
	@Override
	public String getName() {
		return "Colombian Pesos";
	}

	@Override
	public String getCurrencyCode() {
		return "COP";
	}
	
}
