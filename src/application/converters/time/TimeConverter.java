package application.converters.time;

import java.util.HashMap;
import java.util.Map;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class TimeConverter extends UnitTypeConverter {

	private static BaseUnitConverter dayConverter = new DayConverter();
	private static BaseUnitConverter hourConverter = new HourConverter();
	private static BaseUnitConverter millisecondConverter = new MillisecondConverter();
	private static BaseUnitConverter minuteConverter = new MinuteConverter();
	private static BaseUnitConverter monthConverter = new MonthConverter();
	private static BaseUnitConverter secondConverter = new SecondConverter();
	private static BaseUnitConverter yearConverter = new YearConverter();
	
	public TimeConverter() {
		super("Seconds", new HashMap<String, BaseUnitConverter>() {
			{
				put(dayConverter.getName(), dayConverter);
				put(hourConverter.getName(), hourConverter);
				put(millisecondConverter.getName(), millisecondConverter);
				put(minuteConverter.getName(), minuteConverter);
				put(monthConverter.getName(), monthConverter);
				put(secondConverter.getName(), secondConverter);
				put(yearConverter.getName(), yearConverter);
			}
		});
	}

	@Override
	public String getUnitType() {
		return "Time";
	}

}
