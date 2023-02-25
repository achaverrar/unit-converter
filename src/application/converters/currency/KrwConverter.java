package application.converters.currency;

import java.math.BigDecimal;

public class KrwConverter extends CurrencyUnitConverter {

	public KrwConverter() {
		this.MULTIPLIER = new BigDecimal(0.263);
	}
	
	@Override
	public String getName() {
		return "South Korean Wons";
	}
	
	@Override
	public String getCurrencyCode() {
		return "KRW";
	}
	
}
