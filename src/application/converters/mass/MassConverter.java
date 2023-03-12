package application.converters.mass;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class MassConverter extends UnitTypeConverter {

	private static BaseUnitConverter[] massConverters = new BaseUnitConverter[]{
			new BaseUnitConverter("Grams", 0.001),
			new BaseUnitConverter("Kilograms", 1.0),
			new BaseUnitConverter("Milligrams", 0.000001),
			new BaseUnitConverter("Metric Tons", 1000),
			new BaseUnitConverter("Ounces", 0.0283495),
			new BaseUnitConverter("Pounds", 0.453592),
	};
	
	public static HashMap<String, BaseUnitConverter> createHashMap() {
		HashMap<String, BaseUnitConverter> newHashMap = new HashMap<>();

		for(BaseUnitConverter converter: massConverters) {
			newHashMap.put(converter.getName(), converter);
		}

		return newHashMap;
	}
	
	public MassConverter() {
		super("Kilograms", createHashMap());
	}
	
	@Override
	public String getUnitType() {
		return "Mass";
	}

}
