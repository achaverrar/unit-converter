package application.converters.temperature;

import java.math.BigDecimal;
import java.math.RoundingMode;

import application.converters.BaseUnitConverter;

public class RankineConverter extends BaseUnitConverter {
	
	private static final BigDecimal RANKINE_CONSTANT = new BigDecimal(491.67);
	private static final BigDecimal _9_5 = new BigDecimal(1.8);
	private static final BigDecimal _5_9 = new BigDecimal(0.555556);
	
	@Override
	public BigDecimal convertToBase(BigDecimal value) {
		return value.subtract(RANKINE_CONSTANT).multiply(_5_9).setScale(4, RoundingMode.HALF_UP);
	}
	
	@Override
	public BigDecimal convertFromBase(BigDecimal value) {
		return value.multiply(_9_5).add(RANKINE_CONSTANT).setScale(4, RoundingMode.HALF_UP);
	}

	@Override
	public String getName() {
		return "Rankine";
	}
}