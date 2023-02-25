package application.converters.currency;

import java.math.BigDecimal;

public class HnlConverter extends CurrencyUnitConverter {

	public HnlConverter() {
		this.MULTIPLIER = new BigDecimal(0.0051);
	}
	
	@Override
	public String getName() {
		return "Honduran Lempiras";
	}

	@Override
	public String getCurrencyCode() {
		return "HNL";
	}
	
}
