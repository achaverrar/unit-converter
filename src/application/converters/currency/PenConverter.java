package application.converters.currency;

import java.math.BigDecimal;

public class PenConverter extends CurrencyUnitConverter {

	public PenConverter() {
		this.MULTIPLIER = new BigDecimal(0.000797);
	}
	
	@Override
	public String getName() {
		return "Peruvian Soles";
	}

	@Override
	public String getCurrencyCode() {
		return "PEN";
	}

}
