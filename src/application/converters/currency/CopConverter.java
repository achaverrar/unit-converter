package application.converters.currency;

import java.math.BigDecimal;

public class CopConverter extends CurrencyUnitConverter {

	public CopConverter() {
		this.MULTIPLIER = new BigDecimal(1);
	}
	
	public CopConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Colombian Pesos";
	}

}
