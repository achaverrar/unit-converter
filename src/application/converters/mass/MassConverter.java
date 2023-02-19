package application.converters.mass;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class MassConverter extends UnitTypeConverter {

	private static BaseUnitConverter gramConverter = new GramConverter();
	private static BaseUnitConverter kilogramConverter = new KilogramConverter();	
	private static BaseUnitConverter metricTonConverter = new MetricTonConverter();
	private static BaseUnitConverter milligramConverter = new MilligramConverter();
	private static BaseUnitConverter ounceConverter = new OunceConverter();
	private static BaseUnitConverter poundConverter = new PoundConverter();
	
	public MassConverter() {
		super("Kilogram", new HashMap<String, BaseUnitConverter>() {
			{
				put(gramConverter.getName(), gramConverter);
				put(kilogramConverter.getName(), kilogramConverter);
				put(metricTonConverter.getName(), metricTonConverter);
				put(milligramConverter.getName(), milligramConverter);
				put(ounceConverter.getName(), ounceConverter);
				put(poundConverter.getName(), poundConverter);
			}
		});
	}
	@Override
	public String getUnitType() {
		return "Mass";
	}

}
