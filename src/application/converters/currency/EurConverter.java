package application.converters.currency;

import java.math.BigDecimal;

public class EurConverter extends CurrencyUnitConverter {

	public EurConverter() {
		this.MULTIPLIER = new BigDecimal(0.000192);
	}
	
	public EurConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Euros";
	}

}
