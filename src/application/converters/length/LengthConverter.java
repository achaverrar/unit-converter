package application.converters.length;

import application.converters.PartialRangeUnitConverter;
import application.converters.UnitTypeConverter;

public class LengthConverter extends UnitTypeConverter {

	private static PartialRangeUnitConverter[] lengthConverters = new PartialRangeUnitConverter[] {
			new PartialRangeUnitConverter("Metros", 1.0), new PartialRangeUnitConverter("Centímetros", 0.01),
			new PartialRangeUnitConverter("Pies", 0.3048), new PartialRangeUnitConverter("Pulgadas", 0.0254),
			new PartialRangeUnitConverter("Kilómetros", 1000), new PartialRangeUnitConverter("Millas", 1609.344),
			new PartialRangeUnitConverter("Milímetros", 0.001) };

	public LengthConverter() {
		super("Metros", lengthConverters);
	}

	@Override
	public String getUnitType() {
		return "Longitud";
	}

	@Override
	public String getIconName() {
		return "length_filled.png";
	}

}
