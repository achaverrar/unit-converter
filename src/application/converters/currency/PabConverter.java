package application.converters.currency;

import java.math.BigDecimal;

public class PabConverter extends CurrencyUnitConverter {

	public PabConverter() {
		this.MULTIPLIER = new BigDecimal(0.000207);
	}
	
	@Override
	public String getName() {
		return "Panamanian Balboas";
	}

	@Override
	public String getCurrencyCode() {
		return "PAB";
	}

}
