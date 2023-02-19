package application.converters.speed;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class KmphConverter extends BaseUnitConverter {

	public KmphConverter() {
		this.MULTIPLIER = new BigDecimal(0.277778);
	}
	
	@Override
	public String getName() {
		return "Kilometers / Hour";
	}

}
