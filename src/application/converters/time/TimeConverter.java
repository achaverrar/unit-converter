package application.converters.time;

import java.util.HashMap;
import java.util.Map;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class TimeConverter extends UnitTypeConverter {

	private static BaseUnitConverter[] timeConverters = new BaseUnitConverter[] { new BaseUnitConverter("Days", 86400),
			new BaseUnitConverter("Hours", 3600), new BaseUnitConverter("Milliseconds", 0.001),
			new BaseUnitConverter("Minutes", 60), new BaseUnitConverter("Months", 2628000),
			new BaseUnitConverter("Seconds", 1.0), new BaseUnitConverter("Years", 31536000) };

	public TimeConverter() {
		super("Seconds", timeConverters);
	}

	@Override
	public String getUnitType() {
		return "Time";
	}

}