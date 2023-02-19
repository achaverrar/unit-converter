package application.converters.length;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class InchConverter extends BaseUnitConverter{

	public InchConverter() {
		this.MULTIPLIER = new BigDecimal(0.0254);
	}
	
	@Override
	public String getName() {
		return "Inches";
	}
	
}
