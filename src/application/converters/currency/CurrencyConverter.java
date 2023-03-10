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
	private static JSONObject exchangeRates = new JSONObject();

	private static CurrencyUnitConverter[] currencyConverters = new CurrencyUnitConverter[]{new ArsConverter(),
			new ClpConverter(), new CopConverter(), new CrcConverter(), new DopConverter(), new EurConverter(),
			new GbpConverter(), new GtqConverter(), new HnlConverter(), new JpyConverter(), new KrwConverter(),
			new MxnConverter(), new PabConverter(), new PenConverter(), new UsdConverter()};

	public static void updateMULTIPLIERS() {
		if(exchangeRates == null) return;
		
		for(CurrencyUnitConverter converter: currencyConverters) {
			String currencyCode = converter.getCurrencyCode();
			String stringifiedExchangeRate = exchangeRates.get(currencyCode).toString();
			BigDecimal exchangeRate = new BigDecimal(stringifiedExchangeRate);
			converter.setMULTIPLIER(exchangeRate);
		}
	}

	public static HashMap<String, BaseUnitConverter> createHashMap() {
		HashMap<String, BaseUnitConverter> newHashMap = new HashMap<>();

		for(CurrencyUnitConverter converter: currencyConverters) {
			newHashMap.put(converter.getName(), converter);
		}

		return newHashMap;
	}
	
	public static void handleExternalData() {
		try {
			Connection connection = new Connection();
			JSONObject externalData = connection.getExternalData();
			connection.updateFile();
			exchangeRates = externalData.getJSONObject("rates");
		} catch (IOException e){
			System.out.println(e.getStackTrace());
		}
	}

	public CurrencyConverter() {
		super(baseCurrency, createHashMap());
		handleExternalData();
		if(exchangeRates != null) {
			updateMULTIPLIERS();			
		}
	}

	@Override
	public String getUnitType() {
		return "Currency";
	}

}
