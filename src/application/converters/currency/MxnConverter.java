package application.converters.currency;

import java.math.BigDecimal;

public class MxnConverter extends CurrencyUnitConverter {

	public MxnConverter() {
		this.MULTIPLIER = new BigDecimal(0.00381);
	}
	
	@Override
	public String getName() {
		return "Mexican Pesos";
	}

	@Override
	public String getCurrencyCode() {
		return "MXN";
	}

}
