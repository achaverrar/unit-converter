package application.converters.speed;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MpsConverter extends BaseUnitConverter {

	public MpsConverter() {
		this.MULTIPLIER = new BigDecimal(1);
	}
	
	@Override
	public String getName() {
		return "Meters / Second";
	}

}
