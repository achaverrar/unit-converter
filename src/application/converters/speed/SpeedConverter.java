package application.converters.speed;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.FullRangeBaseUnitConverter;
import application.converters.UnitTypeConverter;

public class SpeedConverter extends UnitTypeConverter {

	private static FullRangeBaseUnitConverter[] speedConverters = new FullRangeBaseUnitConverter[] {
			new FullRangeBaseUnitConverter("Kilometers / Hour", 0.277778), new FullRangeBaseUnitConverter("Knots", 0.514444),
			new FullRangeBaseUnitConverter("Meters / Second", 1.0), new FullRangeBaseUnitConverter("Miles / Hour", 0.44704), };

	public SpeedConverter() {
		super("Meters / Second", speedConverters);
	}

	@Override
	public String getUnitType() {
		return "Speed";
	}

	@Override
	public String getIconName() {
		return "speed_filled.png";
	}

}
