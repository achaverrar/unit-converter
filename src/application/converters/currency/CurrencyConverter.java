package application.converters.currency;

import java.util.HashMap;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class CurrencyConverter extends UnitTypeConverter {

	private static BaseUnitConverter usdConverter = new UsdConverter();
	private static BaseUnitConverter copConverter = new CopConverter();
	private static BaseUnitConverter eurConverter = new EurConverter();
	private static BaseUnitConverter gbpConverter = new GbpConverter();
	private static BaseUnitConverter jpyConverter = new JpyConverter();
	private static BaseUnitConverter krwConverter = new KrwConverter();
	private static BaseUnitConverter arsConverter = new ArsConverter();
	private static BaseUnitConverter clpConverter = new ClpConverter();
	private static BaseUnitConverter crcConverter = new CrcConverter();
	private static BaseUnitConverter dopConverter = new DopConverter();
	private static BaseUnitConverter gtqConverter = new GtqConverter();
	private static BaseUnitConverter hnlConverter = new HnlConverter();
	private static BaseUnitConverter mxnConverter = new MxnConverter();
	private static BaseUnitConverter pabConverter = new PabConverter();
	private static BaseUnitConverter penConverter = new PenConverter();
	private static BaseUnitConverter svcConverter = new SvcConverter();

	
	public CurrencyConverter() {
		super("Colombian Pesos", new HashMap<String, BaseUnitConverter>() {
			{
				put(usdConverter.getName(), usdConverter);
				put(copConverter.getName(), copConverter);
				put(eurConverter.getName(), eurConverter);
				put(gbpConverter.getName(), gbpConverter);
				put(jpyConverter.getName(), jpyConverter);
				put(krwConverter.getName(), krwConverter);
				put(arsConverter.getName(), arsConverter);
				put(clpConverter.getName(), clpConverter);
				put(crcConverter.getName(), crcConverter);
				put(dopConverter.getName(), dopConverter);
				put(gtqConverter.getName(), gtqConverter);
				put(hnlConverter.getName(), hnlConverter);
				put(mxnConverter.getName(), mxnConverter);
				put(pabConverter.getName(), pabConverter);
				put(penConverter.getName(), penConverter);
				put(svcConverter.getName(), svcConverter);
			}
		});
	}

	@Override
	public String getUnitType() {
		return "Currency";
	}

}
