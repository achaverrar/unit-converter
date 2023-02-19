package application.converters.currency;

import java.math.BigDecimal;

public class GbpConverter extends CurrencyUnitConverter {

	public GbpConverter() {
		this.MULTIPLIER = new BigDecimal(0.00017);
	}
	
	public GbpConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "British Pounds";
	}

}
