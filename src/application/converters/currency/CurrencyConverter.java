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

	private static CurrencyUnitConverter[] currencyConverters= new CurrencyUnitConverter[]{
			new CurrencyUnitConverter("Colombian Pesos", "COP", 1.0),
			new CurrencyUnitConverter("Argentine Pesos", "ARS", 0.0398),
			new CurrencyUnitConverter("Chilean Pesos", "CLP", 0.162),
			new CurrencyUnitConverter("Costa Rican Colons", "CRC", 0.117),
			new CurrencyUnitConverter("Dominican Pesos", "DOP", 0.0116),			
			new CurrencyUnitConverter("Euros", "EUR", 0.000192),	
			new CurrencyUnitConverter("British Pounds", "GBP", 0.00017),		
			new CurrencyUnitConverter("Guatemalan Quetzals", "GTQ", 0.00162),			
			new CurrencyUnitConverter("Honduran Lempiras", "HNL", 0.0051),			
			new CurrencyUnitConverter("Japanese Yens", "JPY", 0.0275),	
			new CurrencyUnitConverter("South Korean Wons", "KRW", 0.263),		
			new CurrencyUnitConverter("Mexican Pesos", "MXN", 0.00381),
			new CurrencyUnitConverter("United States Dollars", "USD", 0.000207),	
			new CurrencyUnitConverter("Peruvian Soles", "PEN", 0.000797),
			new CurrencyUnitConverter("Panamanian Balboas", "PAB", 0.000207)
	};
	
	public static void updateMULTIPLIERS() {
		if(exchangeRates == null) return;
		
		for(CurrencyUnitConverter converter: currencyConverters) {
			String currencyCode = converter.getCurrencyCode();
			String stringifiedExchangeRate = exchangeRates.get(currencyCode).toString();
			BigDecimal exchangeRate = new BigDecimal(stringifiedExchangeRate);
			converter.setConversionFactor(exchangeRate);
		}
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
		super(baseCurrency, currencyConverters);
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
