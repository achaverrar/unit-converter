package application.converters;

// Library for conversions
import java.math.BigDecimal;
import java.math.RoundingMode;

import utilities.InvalidInputException;

public abstract class BaseUnitConverter {
	private String name;
	protected BigDecimal CONVERSION_FACTOR;

	public BaseUnitConverter(String name) {
		this.name = name;
	}

	public BaseUnitConverter(String name, double conversionFactor) {
		this.name = name;
		this.CONVERSION_FACTOR = new BigDecimal(conversionFactor);
	}

	public abstract BigDecimal convertToBase(String input) throws InvalidInputException;

	public abstract BigDecimal convertFromBase(String input) throws InvalidInputException;

	public BigDecimal convertFromBase(BigDecimal value) {
		return value.divide(CONVERSION_FACTOR, 4, RoundingMode.HALF_UP);
	}

	public abstract BigDecimal formatInput(String input) throws InvalidInputException;

	public String getName() {
		return this.name;
	}

	public String getIconName() {
		return null;
	}
}
