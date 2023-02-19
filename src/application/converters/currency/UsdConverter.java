package application.converters.currency;

import java.math.BigDecimal;

public class UsdConverter extends CurrencyUnitConverter {

	public UsdConverter() {
		this.MULTIPLIER = new BigDecimal(0.000207);
	}
	
	@Override
	public String getName() {
		return "United States Dollars";
	}

}
