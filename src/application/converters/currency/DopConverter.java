package application.converters.currency;

import java.math.BigDecimal;

public class DopConverter extends CurrencyUnitConverter {

	public DopConverter() {
		this.MULTIPLIER = new BigDecimal(0.0116);
	}
	
	@Override
	public String getName() {
		return "Dominican Pesos";
	}

	@Override
	public String getCurrencyCode() {
		return "DOP";
	}
	
}
