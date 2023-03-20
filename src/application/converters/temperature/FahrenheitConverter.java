package application.converters.temperature;

import java.math.BigDecimal;
import java.math.RoundingMode;

import application.converters.FullRangeBaseUnitConverter;
import utilities.InvalidInputException;

public class FahrenheitConverter extends FullRangeBaseUnitConverter {

	public FahrenheitConverter() {
		super("Grados Fahrenheit");
	}

	private static final BigDecimal _9_5 = new BigDecimal(1.8);
	private static final BigDecimal _5_9 = new BigDecimal(0.555556);
	private static final BigDecimal _32 = new BigDecimal(32);

	@Override
	public BigDecimal convertToBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		return value.subtract(_32).multiply(_5_9).setScale(4, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal convertFromBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		return value.multiply(_9_5).add(_32).setScale(4, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal convertFromBase(BigDecimal input) {
		return input.multiply(_9_5).add(_32).setScale(4, RoundingMode.HALF_UP);
	}

}
