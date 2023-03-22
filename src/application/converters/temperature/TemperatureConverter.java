package application.converters.temperature;

import application.converters.FullRangeBaseUnitConverter;
import application.converters.UnitTypeConverter;

public class TemperatureConverter extends UnitTypeConverter {

	private static FullRangeBaseUnitConverter[] temperatureConverters = new FullRangeBaseUnitConverter[] { new CelsiusConverter(),
			new FahrenheitConverter(), new KelvinConverter(), new RankineConverter(), };

	public TemperatureConverter() {
		super("Grados Celsius", temperatureConverters);
	}

	@Override
	public String getUnitType() {
		return "Temperatura";
	}

	@Override
	public String getIconName() {
		return "temperature.png";
	}

}
