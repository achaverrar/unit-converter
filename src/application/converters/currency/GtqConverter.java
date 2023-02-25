package application.converters.currency;

import java.math.BigDecimal;

public class GtqConverter extends CurrencyUnitConverter {

	public GtqConverter() {
		this.MULTIPLIER = new BigDecimal(0.00162);
	}
	
	public GtqConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Guatemalan Quetzals";
	}

	@Override
	public String getCurrencyCode() {
		return "GTQ";
	}
}
