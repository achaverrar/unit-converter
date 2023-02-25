package application.converters.currency;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class CurrencyConverter extends UnitTypeConverter {
	private static String baseCurrency = "Colombian Pesos";
	
	private static List<CurrencyUnitConverter> currencyConverters = Arrays.asList(
			new UsdConverter(),
			new CopConverter(),
			new EurConverter(),
			new GbpConverter(),
			new JpyConverter(),
			new KrwConverter(),
			new ArsConverter(),
			new ClpConverter(),
			new CrcConverter(),
			new DopConverter(),
			new GtqConverter(),
			new HnlConverter(),
			new MxnConverter(),
			new PabConverter(),
			new PenConverter()
			);
	
	public static HashMap<String, BaseUnitConverter> createHashMap() {
		HashMap<String, BaseUnitConverter> newHashMap = new HashMap<>();
		
		currencyConverters.forEach(converter ->{
			newHashMap.put(converter.getName(), converter);
		});
		
		return newHashMap;
	}
	
	public CurrencyConverter() {
		super(baseCurrency, createHashMap());
	}

	@Override
	public String getUnitType() {
		return "Currency";
	}

}
