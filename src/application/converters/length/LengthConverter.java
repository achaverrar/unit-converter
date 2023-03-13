package application.converters.length;

import java.util.HashMap;

import application.converters.PartialRangeUnitConverter;
import application.converters.UnitTypeConverter;

public class LengthConverter extends UnitTypeConverter {

	private static PartialRangeUnitConverter[] lengthConverters = new PartialRangeUnitConverter[] {
			new PartialRangeUnitConverter("Meters", 1.0), new PartialRangeUnitConverter("Centimeters", 0.01),
			new PartialRangeUnitConverter("Feet", 0.3048), new PartialRangeUnitConverter("Inches", 0.0254),
			new PartialRangeUnitConverter("Kilometers", 1000), new PartialRangeUnitConverter("Miles", 1609.344),
			new PartialRangeUnitConverter("Millimeters", 0.001) };

	public LengthConverter() {
		super("Meters", lengthConverters);
	}

	@Override
	public String getUnitType() {
		return "Length";
	}

}
