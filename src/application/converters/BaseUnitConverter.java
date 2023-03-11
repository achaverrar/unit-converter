package application.converters;

// Library for conversions
import java.math.BigDecimal;
import java.math.RoundingMode;

import application.InvalidInputException;

public abstract class BaseUnitConverter {
	protected BigDecimal MULTIPLIER;
	
	public abstract String getName();
	
	public BigDecimal convertToBase(BigDecimal value) {
		// up to 4 decimal places, approximate to the next unit from .5 
		return value.multiply(MULTIPLIER).setScale(4, RoundingMode.HALF_UP);
	}
	
	public BigDecimal convertFromBase(BigDecimal value) {
		return value.divide(MULTIPLIER, 4, RoundingMode.HALF_UP);
	}
	
	public BigDecimal formatInput(String input) throws InvalidInputException {
		try {
			return new BigDecimal(Double.parseDouble(input));
		} catch (NumberFormatException e) {
			throw new InvalidInputException("El valor ingresado debe ser un número");
		}
	}
}
