package application.converters.temperature;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class TemperatureConverter extends UnitTypeConverter {

	private static BaseUnitConverter[] temperatureConverters = new BaseUnitConverter[] { new CelsiusConverter(),
			new FahrenheitConverter(), new KelvinConverter(), new RankineConverter(), };

	public TemperatureConverter() {
		super("Celsius", temperatureConverters);
	}

	@Override
	public String getUnitType() {
		return "Temperature";
	}

}
