package application.converters.currency;

import java.math.BigDecimal;

public class DopConverter extends CurrencyUnitConverter {

	public DopConverter() {
		this.MULTIPLIER = new BigDecimal(0.0116);
	}
	
	public DopConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Dominican Pesos";
	}

}
