package application.converters.length;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class LengthConverter extends UnitTypeConverter {

	private static BaseUnitConverter meterConverter = new MeterConverter();
	private static BaseUnitConverter footConverter = new FootConverter();
	
	public LengthConverter() {
		super("Meter", new HashMap<String, BaseUnitConverter>() {
			{
				put(meterConverter.getName(), meterConverter);
				put(footConverter.getName(), footConverter);
			}
		});
	}
	@Override
	public String getUnitType() {
		return "Length";
	}

}
