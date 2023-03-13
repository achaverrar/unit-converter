package application.converters.currency;

import java.math.BigDecimal;

import application.converters.PartialRangeUnitConverter;

public class CurrencyUnitConverter extends PartialRangeUnitConverter {
	private String CURRENCY_CODE;
	
	public CurrencyUnitConverter(String name, String currencyCode, double conversionFactor) {
		super(name, conversionFactor);
		this.CURRENCY_CODE = currencyCode;
	}
	
	public void setConversionFactor(BigDecimal newConversionFactor) {
		this.CONVERSION_FACTOR = newConversionFactor;
	}
	
	public String getCurrencyCode() {
		return CURRENCY_CODE;
	}
}
