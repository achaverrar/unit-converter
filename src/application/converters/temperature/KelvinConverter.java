package application.converters.temperature;

import java.math.BigDecimal;
import java.math.RoundingMode;

import application.InvalidInputException;
import application.converters.FullRangeBaseUnitConverter;

public class KelvinConverter extends FullRangeBaseUnitConverter {

	public KelvinConverter() {
		super("Kelvin");
	}

	private static final BigDecimal KELVIN_CONSTANT = new BigDecimal(273.15);

	@Override
	public BigDecimal convertToBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		return value.subtract(KELVIN_CONSTANT).setScale(4, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal convertFromBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		return value.add(KELVIN_CONSTANT).setScale(4, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal convertFromBase(BigDecimal input) {
		return input.add(KELVIN_CONSTANT).setScale(4, RoundingMode.HALF_UP);
	}

}
