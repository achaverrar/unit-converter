package application.converters.volume;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class VolumeConverter extends UnitTypeConverter {

	private static BaseUnitConverter[] volumeConverters = new BaseUnitConverter[] { new BaseUnitConverter("Cups", 0.24),
			new BaseUnitConverter("Fluid Ounces", 0.0295735), new BaseUnitConverter("Gallons", 3.78541),
			new BaseUnitConverter("Liters", 1.0), new BaseUnitConverter("Milliliters", 0.001),
			new BaseUnitConverter("Pints", 0.473176), new BaseUnitConverter("Quarts", 0.946353),
			new BaseUnitConverter("Tablespoons", 0.0147868), new BaseUnitConverter("Teaspoons", 0.00492892) };

	public VolumeConverter() {
		super("Liters", volumeConverters);
	}

	@Override
	public String getUnitType() {
		return "Volume";
	}

}
