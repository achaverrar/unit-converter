package application.converters.mass;

import java.math.BigDecimal;

import application.converters.BaseUnitConverter;

public class MetricTonConverter extends BaseUnitConverter {

	public MetricTonConverter() {
		this.MULTIPLIER = new BigDecimal(1000);
	}
	
	@Override
	public String getName() {
		return "Metric Tons";
	}
	
}