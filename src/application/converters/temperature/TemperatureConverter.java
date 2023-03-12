package application.converters.temperature;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class TemperatureConverter extends UnitTypeConverter {

	private static BaseUnitConverter[] temperatureConverters = new BaseUnitConverter[] { new CelsiusConverter(),
			new FahrenheitConverter(), new KelvinConverter(), new RankineConverter(), };

	public static HashMap<String, BaseUnitConverter> createHashMap() {
		HashMap<String, BaseUnitConverter> newHashMap = new HashMap<>();

		for (BaseUnitConverter converter : temperatureConverters) {
			newHashMap.put(converter.getName(), converter);
		}

		return newHashMap;
	}

	public TemperatureConverter() {
		super("Celsius", createHashMap());

	}

	@Override
	public String getUnitType() {
		return "Temperature";
	}
}
