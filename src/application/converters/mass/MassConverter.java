package application.converters.mass;

import java.util.HashMap;

import application.converters.PartialRangeUnitConverter;
import application.converters.UnitTypeConverter;

public class MassConverter extends UnitTypeConverter {

	private static PartialRangeUnitConverter[] massConverters = new PartialRangeUnitConverter[] { new PartialRangeUnitConverter("Grams", 0.001),
			new PartialRangeUnitConverter("Kilograms", 1.0), new PartialRangeUnitConverter("Milligrams", 0.000001),
			new PartialRangeUnitConverter("Metric Tons", 1000), new PartialRangeUnitConverter("Ounces", 0.0283495),
			new PartialRangeUnitConverter("Pounds", 0.453592), };

	public MassConverter() {
		super("Kilograms", massConverters);
	}

	@Override
	public String getUnitType() {
		return "Mass";
	}

	@Override
	public String getIconName() {
		return "mass.png";
	}

}
