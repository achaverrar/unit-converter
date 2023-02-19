package application.converters.currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

import application.converters.BaseUnitConverter;

public abstract class CurrencyUnitConverter extends BaseUnitConverter {

	public BigDecimal convertToBase(BigDecimal value) { 
		return value.divide(MULTIPLIER, 4, RoundingMode.HALF_UP);
	}
	
	public BigDecimal convertFromBase(BigDecimal value) {
		return value.multiply(MULTIPLIER).setScale(4, RoundingMode.HALF_UP);
	}

}
