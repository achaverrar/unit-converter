package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class UsdConverter extends BaseUnitConverter {

	public UsdConverter() {
		this.MULTIPLIER = new BigDecimal(4883.08);
	}
	
	@Override
	public String getName() {
		return "United States Dollars";
	}

}
