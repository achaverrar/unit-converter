package application.converters.currency;

import java.math.BigDecimal;

public class KrwConverter extends CurrencyUnitConverter {

	public KrwConverter() {
		this.MULTIPLIER = new BigDecimal(0.263);
	}
	
	public KrwConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "South Korean Wons";
	}

}
