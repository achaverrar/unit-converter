package application.converters.volume;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class VolumeConverter extends UnitTypeConverter {

	private static BaseUnitConverter cupConverter = new CupConverter();
	private static BaseUnitConverter fluidOunceConverter = new FluidOunceConverter();
	private static BaseUnitConverter gallonConverter = new GallonConverter();
	private static BaseUnitConverter literConverter = new LiterConverter();
	private static BaseUnitConverter milliliterConverter = new MilliliterConverter();
	private static BaseUnitConverter pintConverter = new PintConverter();
	private static BaseUnitConverter quartConverter = new QuartConverter();
	private static BaseUnitConverter tableSpoonConverter = new TableSpoonConverter();
	private static BaseUnitConverter teaspoonConverter = new TeaspoonConverter();
	
	public VolumeConverter() {
		super("Meter", new HashMap<String, BaseUnitConverter>() {
			{
				put(cupConverter.getName(), cupConverter);
				put(fluidOunceConverter.getName(), fluidOunceConverter);
				put(gallonConverter.getName(), gallonConverter);
				put(literConverter.getName(), literConverter);
				put(milliliterConverter.getName(), milliliterConverter);
				put(pintConverter.getName(), pintConverter);
				put(quartConverter.getName(), quartConverter);
				put(tableSpoonConverter.getName(), tableSpoonConverter);
				put(teaspoonConverter.getName(), teaspoonConverter);
			}
		});
	}
	
	@Override
	public String getUnitType() {
		return "Volume";
	}

}
