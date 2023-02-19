package application.converters.mass;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class OunceConverter extends BaseUnitConverter{

	public OunceConverter() {
		this.MULTIPLIER = new BigDecimal(0.0283495);
	}
	
	@Override
	public String getName() {
		return "Ounces";
	}
	
}
