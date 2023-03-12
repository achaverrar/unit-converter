package application.converters.currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

import application.InvalidInputException;
import application.converters.BaseUnitConverter;

public class CurrencyUnitConverter extends BaseUnitConverter {
	private String CURRENCY_CODE;
	
	public CurrencyUnitConverter(String name, String currencyCode, double conversionFactor) {
		super(name, conversionFactor);
		this.CURRENCY_CODE = currencyCode;
	}
	
	@Override
	public BigDecimal convertToBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		return value.divide(CONVERSION_FACTOR, 4, RoundingMode.HALF_UP);
	}
	
	@Override
	public BigDecimal convertFromBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		return value.multiply(CONVERSION_FACTOR).setScale(4, RoundingMode.HALF_UP);
	}
	
	public void setConversionFactor(BigDecimal newConversionFactor) {
		this.CONVERSION_FACTOR = newConversionFactor;
	}
	
	public String getCurrencyCode() {
		return CURRENCY_CODE;
	}
}
