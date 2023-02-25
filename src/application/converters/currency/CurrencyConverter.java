package application.converters.currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class CurrencyConverter extends UnitTypeConverter {
	private static String baseCurrency = "Colombian Pesos";
	private Map<String,Object> x;
	private static CurrencyUnitConverter usdConverter = new UsdConverter();
	private static CurrencyUnitConverter copConverter = new CopConverter();
	private static CurrencyUnitConverter eurConverter = new EurConverter();
	private static CurrencyUnitConverter gbpConverter = new GbpConverter();
	private static CurrencyUnitConverter jpyConverter = new JpyConverter();
	private static CurrencyUnitConverter krwConverter = new KrwConverter();
	private static CurrencyUnitConverter arsConverter = new ArsConverter();
	private static CurrencyUnitConverter clpConverter = new ClpConverter();
	private static CurrencyUnitConverter crcConverter = new CrcConverter();
	private static CurrencyUnitConverter dopConverter = new DopConverter();
	private static CurrencyUnitConverter gtqConverter = new GtqConverter();
	private static CurrencyUnitConverter hnlConverter = new HnlConverter();
	private static CurrencyUnitConverter mxnConverter = new MxnConverter();
	private static CurrencyUnitConverter pabConverter = new PabConverter();
	private static CurrencyUnitConverter penConverter = new PenConverter();
		
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
			}
		});
	}

	@Override
	public String getUnitType() {
		return "Currency";
	}

}
