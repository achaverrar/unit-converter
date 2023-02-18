package application.converters.temperature;
import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class TemperatureConverter extends UnitTypeConverter {
	private static BaseUnitConverter celsiusConverter = new CelsiusConverter();
	private static BaseUnitConverter fahrenhenitConverter = new FahrenheitConverter();
	private static BaseUnitConverter kelvinConverter = new KelvinConverter();
	private static BaseUnitConverter rankineConverter = new RankineConverter();
	
	public TemperatureConverter() {
		super("Celsius", new HashMap<String, BaseUnitConverter>() {
			{
				put(celsiusConverter.getName(), celsiusConverter);
				put(fahrenhenitConverter.getName(), fahrenhenitConverter);
				put(kelvinConverter.getName(), kelvinConverter);
				put(rankineConverter.getName(), rankineConverter);
			}
		});
	}
	
	@Override
	public String getUnitType() {
		return "Temperature";
	}
}

