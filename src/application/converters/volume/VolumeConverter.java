package application.converters.volume;

import java.util.HashMap;

import application.converters.PartialRangeUnitConverter;
import application.converters.UnitTypeConverter;

public class VolumeConverter extends UnitTypeConverter {

	private static PartialRangeUnitConverter[] volumeConverters = new PartialRangeUnitConverter[] { new PartialRangeUnitConverter("Cups", 0.24),
			new PartialRangeUnitConverter("Fluid Ounces", 0.0295735), new PartialRangeUnitConverter("Gallons", 3.78541),
			new PartialRangeUnitConverter("Liters", 1.0), new PartialRangeUnitConverter("Milliliters", 0.001),
			new PartialRangeUnitConverter("Pints", 0.473176), new PartialRangeUnitConverter("Quarts", 0.946353),
			new PartialRangeUnitConverter("Tablespoons", 0.0147868), new PartialRangeUnitConverter("Teaspoons", 0.00492892) };

	public VolumeConverter() {
		super("Liters", volumeConverters);
	}

	@Override
	public String getUnitType() {
		return "Volume";
	}

	@Override
	public String getIconName() {
		return "volume_filled1.png";
	}

}
