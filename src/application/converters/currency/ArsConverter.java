package application.converters.currency;

import java.math.BigDecimal;

public class ArsConverter extends CurrencyUnitConverter {

	public ArsConverter() {
		this.MULTIPLIER = new BigDecimal(0.0398);
	}
	
	@Override
	public String getName() {
		return "Argentine Pesos";
	}

	@Override
	public String getCurrencyCode() {
		return "ARS";
	}

}
