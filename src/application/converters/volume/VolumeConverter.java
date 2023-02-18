package application.converters.volume;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class VolumeConverter extends UnitTypeConverter {

	private static BaseUnitConverter literConverter = new LiterConverter();
	private static BaseUnitConverter gallonConverter = new GallonConverter();
	
	public VolumeConverter() {
		super("Meter", new HashMap<String, BaseUnitConverter>() {
			{
				put(literConverter.getName(), literConverter);
				put(gallonConverter.getName(), gallonConverter);
			}
		});
	}
	@Override
	public String getUnitType() {
		return "Volume";
	}

}
