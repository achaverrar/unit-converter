package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class GallonConverter extends BaseUnitConverter{

	public GallonConverter() {
		this.MULTIPLIER = new BigDecimal(3.785);
	}
	
	@Override
	public String getName() {
		return "Gallon";
	}
	
}
