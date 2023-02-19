package application.converters.currency;

import java.math.BigDecimal;

public class HnlConverter extends CurrencyUnitConverter {

	public HnlConverter() {
		this.MULTIPLIER = new BigDecimal(0.0051);
	}
	
	public HnlConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Honduran Lempiras";
	}

}
