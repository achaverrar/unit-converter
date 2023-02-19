package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class HnlConverter extends BaseUnitConverter {

	public HnlConverter() {
		this.MULTIPLIER = new BigDecimal(199.96);
	}
	
	public HnlConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Honduran Lempiras";
	}

}
