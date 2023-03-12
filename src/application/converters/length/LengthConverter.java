package application.converters.length;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;
import application.converters.currency.CurrencyUnitConverter;

public class LengthConverter extends UnitTypeConverter {

	private static BaseUnitConverter[] lengthConverters = new BaseUnitConverter[] {
			new BaseUnitConverter("Meters", 1.0), new BaseUnitConverter("Centimeters", 0.01),
			new BaseUnitConverter("Feet", 0.3048), new BaseUnitConverter("Inches", 0.0254),
			new BaseUnitConverter("Kilometers", 1000), new BaseUnitConverter("Miles", 1609.344),
			new BaseUnitConverter("Millimeters", 0.001) };

	public LengthConverter() {
		super("Meters", lengthConverters);
	}

	@Override
	public String getUnitType() {
		return "Length";
	}

}
