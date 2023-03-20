package application.converters;

import java.math.BigDecimal;
import java.math.RoundingMode;

import utilities.InvalidInputException;

public class PartialRangeUnitConverter extends BaseUnitConverter {
	private BigDecimal MINIMUM_VALID_VALUE = new BigDecimal("0.0");

	public PartialRangeUnitConverter(String name) {
		super(name);
	}

	public PartialRangeUnitConverter(String name, double conversionFactor) {
		super(name, conversionFactor);
	}

	public BigDecimal convertToBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		// up to 4 decimal places, approximate to the next unit from .5
		validateInputNumber(value);
		return value.multiply(CONVERSION_FACTOR).setScale(4, RoundingMode.HALF_UP);
	}

	public BigDecimal convertFromBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		validateInputNumber(value);
		return value.divide(CONVERSION_FACTOR, 4, RoundingMode.HALF_UP);
	}

	public BigDecimal formatInput(String input) throws InvalidInputException {
		try {
			return new BigDecimal(Double.parseDouble(input));
		} catch (NumberFormatException e) {
			throw new InvalidInputException("El valor ingresado debe ser un número");
		}
	}

	public void validateInputNumber(BigDecimal number) throws InvalidInputException {
		if (number.compareTo(MINIMUM_VALID_VALUE) < 0) {
			throw new InvalidInputException("El número ingresado no puede ser negativo");
		}
	}
}
