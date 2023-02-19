package application.converters.length;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class LengthConverter extends UnitTypeConverter {

	private static BaseUnitConverter meterConverter = new MeterConverter();
	private static BaseUnitConverter footConverter = new FootConverter();
	private static BaseUnitConverter centimeterConverter = new CentimeterConverter();
	private static BaseUnitConverter inchConverter = new InchConverter();
	private static BaseUnitConverter kilometerConverter = new KilometerConverter();
	private static BaseUnitConverter mileConverter = new MileConverter();	
	private static BaseUnitConverter millimeterConverter = new MillimeterConverter();	
	
	public LengthConverter() {
		super("Meters", new HashMap<String, BaseUnitConverter>() {
			{
				put(meterConverter.getName(), meterConverter);
				put(footConverter.getName(), footConverter);
				put(centimeterConverter.getName(), centimeterConverter);
				put(inchConverter.getName(), inchConverter);
				put(kilometerConverter.getName(), kilometerConverter);
				put(mileConverter.getName(), mileConverter);
				put(millimeterConverter.getName(), millimeterConverter);
			}
		});
	}
	@Override
	public String getUnitType() {
		return "Length";
	}

}
