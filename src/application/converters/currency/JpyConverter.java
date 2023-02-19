package application.converters.currency;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class JpyConverter extends BaseUnitConverter {

	public JpyConverter() {
		this.MULTIPLIER = new BigDecimal(36.41);
	}
	
	public JpyConverter(BigDecimal value) {
		this.MULTIPLIER = value;
	}
	
	@Override
	public String getName() {
		return "Japanese Yens";
	}

}
