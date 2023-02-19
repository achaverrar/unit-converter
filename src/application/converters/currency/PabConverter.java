package application.converters.currency;

import java.math.BigDecimal;

public class PabConverter extends CurrencyUnitConverter {

	public PabConverter() {
		this.MULTIPLIER = new BigDecimal(0.000207);
	}
	
	public PabConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Panamanian Balboas";
	}

}
