package application.converters.time;

import java.util.HashMap;
import java.util.Map;

import application.converters.PartialRangeUnitConverter;
import application.converters.UnitTypeConverter;

public class TimeConverter extends UnitTypeConverter {

	private static PartialRangeUnitConverter[] timeConverters = new PartialRangeUnitConverter[] {
			new PartialRangeUnitConverter("Days", 86400), new PartialRangeUnitConverter("Hours", 3600),
			new PartialRangeUnitConverter("Milliseconds", 0.001), new PartialRangeUnitConverter("Minutes", 60),
			new PartialRangeUnitConverter("Months", 2628000), new PartialRangeUnitConverter("Seconds", 1.0),
			new PartialRangeUnitConverter("Years", 31536000) };

	public TimeConverter() {
		super("Seconds", timeConverters);
	}

	@Override
	public String getUnitType() {
		return "Time";
	}

	@Override
	public String getIconName() {
		return "time_filled.png";
	}

}