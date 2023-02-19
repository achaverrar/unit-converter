package application.converters.currency;

import java.math.BigDecimal;

public class ArsConverter extends CurrencyUnitConverter {

	public ArsConverter() {
		this.MULTIPLIER = new BigDecimal(0.0398);
	}
	
	public ArsConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Argentine Pesos";
	}

}
