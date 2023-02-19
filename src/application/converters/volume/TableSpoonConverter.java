package application.converters.volume;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class TableSpoonConverter extends BaseUnitConverter{

	public TableSpoonConverter() {
		this.MULTIPLIER = new BigDecimal(0.0147868);
	}
	
	@Override
	public String getName() {
		return "Tablespoons";
	}
	
}
