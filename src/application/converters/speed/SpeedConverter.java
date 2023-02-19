package application.converters.speed;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class SpeedConverter extends UnitTypeConverter {

	private static BaseUnitConverter kmphConverter = new KmphConverter();
	private static BaseUnitConverter knotConverter = new KnotConverter();
	private static BaseUnitConverter mphConverter = new MphConverter();
	private static BaseUnitConverter mpsConverter = new MpsConverter();
	
	public SpeedConverter() {
		super("Meters / Second", new HashMap<String, BaseUnitConverter>() {
			{
				put(kmphConverter.getName(), kmphConverter);
				put(knotConverter.getName(), knotConverter);
				put(mphConverter.getName(), mphConverter);
				put(mpsConverter.getName(), mpsConverter);
			}
		});
	}
	
	@Override
	public String getUnitType() {
		return "Speed";
	}

}
