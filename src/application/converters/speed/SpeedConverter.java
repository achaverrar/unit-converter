package application.converters.speed;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class SpeedConverter extends UnitTypeConverter {

	private static BaseUnitConverter[] speedConverters= new BaseUnitConverter[]{
			new BaseUnitConverter("Kilometers / Hour", 0.277778),
			new BaseUnitConverter("Knots", 0.514444),
			new BaseUnitConverter("Meters / Second", 1.0),
			new BaseUnitConverter("Miles / Hour", 0.44704),	
	};
	
	public static HashMap<String, BaseUnitConverter> createHashMap() {
		HashMap<String, BaseUnitConverter> newHashMap = new HashMap<>();

		for(BaseUnitConverter converter: speedConverters) {
			newHashMap.put(converter.getName(), converter);
		}

		return newHashMap;
	}
	
	public SpeedConverter() {
		super("Meters / Second", createHashMap());
	}
	
	@Override
	public String getUnitType() {
		return "Speed";
	}

}
