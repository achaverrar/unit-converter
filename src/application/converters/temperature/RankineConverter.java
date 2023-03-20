package application.converters.temperature;

import java.math.BigDecimal;
import java.math.RoundingMode;

import application.converters.FullRangeBaseUnitConverter;
import utilities.InvalidInputException;

public class RankineConverter extends FullRangeBaseUnitConverter {

	public RankineConverter() {
		super("Grados Rankine");
	}

	private static final BigDecimal RANKINE_CONSTANT = new BigDecimal(491.67);
	private static final BigDecimal _9_5 = new BigDecimal(1.8);
	private static final BigDecimal _5_9 = new BigDecimal(0.555556);

	@Override
	public BigDecimal convertToBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		return value.subtract(RANKINE_CONSTANT).multiply(_5_9).setScale(4, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal convertFromBase(String input) throws InvalidInputException {
		BigDecimal value = formatInput(input);
		return value.multiply(_9_5).add(RANKINE_CONSTANT).setScale(4, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal convertFromBase(BigDecimal input) {
		return input.multiply(_9_5).add(RANKINE_CONSTANT).setScale(4, RoundingMode.HALF_UP);
	}

}