package application.converters.currency;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class CurrencyConverter extends UnitTypeConverter {
	private static String baseCurrency = "Colombian Pesos";
	private static String url = "https://api.exchangerate-api.com/v4/latest/COP";
	private static String path = "./currency.txt";

	private static List<CurrencyUnitConverter> currencyConverters = Arrays.asList(new ArsConverter(),
			new ClpConverter(), new CopConverter(), new CrcConverter(), new DopConverter(), new EurConverter(),
			new GbpConverter(), new GtqConverter(), new HnlConverter(), new JpyConverter(), new KrwConverter(),
			new MxnConverter(), new PabConverter(), new PenConverter(), new UsdConverter());

	public static void updateMULTIPLIERS() {
		try {
			Connection connection = new Connection(url, path);
			JSONObject rawJSON = connection.getExternalData();
			JSONObject exchangeRates = rawJSON.getJSONObject("rates");
			currencyConverters.forEach(converter -> {
				String currencyCode = converter.getCurrencyCode();
				String stringifiedExchangeRate = exchangeRates.get(currencyCode).toString();
				BigDecimal exchangeRate = new BigDecimal(stringifiedExchangeRate);
				converter.setMULTIPLIER(exchangeRate);
			});
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}

	public static HashMap<String, BaseUnitConverter> createHashMap() {
		HashMap<String, BaseUnitConverter> newHashMap = new HashMap<>();

		currencyConverters.forEach(converter -> {
			newHashMap.put(converter.getName(), converter);
		});

		return newHashMap;
	}

	public CurrencyConverter() {
		super(baseCurrency, createHashMap());
		updateMULTIPLIERS();
	}

	@Override
	public String getUnitType() {
		return "Currency";
	}

}
