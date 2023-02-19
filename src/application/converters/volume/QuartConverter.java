package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class QuartConverter extends BaseUnitConverter{

	public QuartConverter() {
		this.MULTIPLIER = new BigDecimal(0.946353);
	}
	
	@Override
	public String getName() {
		return "Quarts";
	}
	
}
