package application.converters.currency;

import java.io.IOException;
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
	private static JSONObject exchangeRates = new JSONObject();

	private static List<CurrencyUnitConverter> currencyConverters = Arrays.asList(new ArsConverter(),
			new ClpConverter(), new CopConverter(), new CrcConverter(), new DopConverter(), new EurConverter(),
			new GbpConverter(), new GtqConverter(), new HnlConverter(), new JpyConverter(), new KrwConverter(),
			new MxnConverter(), new PabConverter(), new PenConverter(), new UsdConverter());

	public static void updateMULTIPLIERS() {
		if(exchangeRates == null) return;
		
		currencyConverters.forEach(converter -> {
			String currencyCode = converter.getCurrencyCode();
			String stringifiedExchangeRate = exchangeRates.get(currencyCode).toString();
			BigDecimal exchangeRate = new BigDecimal(stringifiedExchangeRate);
			converter.setMULTIPLIER(exchangeRate);
		});
	}

	public static HashMap<String, BaseUnitConverter> createHashMap() {
		HashMap<String, BaseUnitConverter> newHashMap = new HashMap<>();

		currencyConverters.forEach(converter -> {
			newHashMap.put(converter.getName(), converter);
		});

		return newHashMap;
	}
	
	public static void HandleExternalData() {
		try {
			Connection connection = new Connection(url, path);
			JSONObject externalData = connection.getExternalData();
			connection.writeFileFromJSON(externalData);
			exchangeRates = externalData.getJSONObject("rates");
		} catch (IOException e){
			System.out.println(e.getStackTrace());
		}
	}

	public CurrencyConverter() {
		super(baseCurrency, createHashMap());
		HandleExternalData();
		updateMULTIPLIERS();
	}

	@Override
	public String getUnitType() {
		return "Currency";
	}

}
