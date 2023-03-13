package application.converters;

import java.math.BigDecimal;
import java.math.RoundingMode;

import application.InvalidInputException;

public class FullRangeBaseUnitConverter extends BaseUnitConverter {
	
	public FullRangeBaseUnitConverter(String name) {
		super(name);
	}

	public FullRangeBaseUnitConverter(String name, double conversionFactor) {
		super(name, conversionFactor);
	}

	@Override
	public BigDecimal convertToBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		return value.multiply(CONVERSION_FACTOR).setScale(4, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal convertFromBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		return value.divide(CONVERSION_FACTOR, 4, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal formatInput(String input) throws InvalidInputException {
		try {
			return new BigDecimal(Double.parseDouble(input));
		} catch (NumberFormatException e) {
			if (input.equals("-")) {
				throw new InvalidInputException("");
			} else {
				throw new InvalidInputException("El valor ingresado debe ser un número");
			}
		}
	}
}