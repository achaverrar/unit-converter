package application.converters.currency;

import java.math.BigDecimal;

public class ClpConverter extends CurrencyUnitConverter {

	public ClpConverter() {
		this.MULTIPLIER = new BigDecimal(0.162);
	}

	@Override
	public String getName() {
		return "Chilean Pesos";
	}

	@Override
	public String getCurrencyCode() {
		return "CLP";
	}
	
}
