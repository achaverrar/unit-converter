package application.converters.currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

import application.converters.PartialRangeUnitConverter;
import utilities.InvalidInputException;

public class CurrencyUnitConverter extends PartialRangeUnitConverter {
    private String CURRENCY_CODE;

    public CurrencyUnitConverter(String name, String currencyCode, double conversionFactor) {
        super(name, conversionFactor);
        this.CURRENCY_CODE = currencyCode;
    }

    public void setConversionFactor(BigDecimal newConversionFactor) {
        this.CONVERSION_FACTOR = newConversionFactor;
    }

    @Override
    public BigDecimal convertToBase(String input) throws InvalidInputException {
        BigDecimal value = formatInput(input);
        // up to 4 decimal places, approximate to the next unit from .5
        validateInputNumber(value);
        return value.divide(CONVERSION_FACTOR, 4, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal convertFromBase(String input) throws InvalidInputException {
        BigDecimal value = formatInput(input);
        validateInputNumber(value);
        return value.multiply(CONVERSION_FACTOR).setScale(4, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal convertFromBase(BigDecimal value) {
        return value.multiply(CONVERSION_FACTOR).setScale(4, RoundingMode.HALF_UP);
    }

    public String getCurrencyCode() {
        return CURRENCY_CODE;
    }

    @Override
    public String getIconName() {
        return CURRENCY_CODE + ".png";
    }
}