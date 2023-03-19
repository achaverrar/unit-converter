package application.converters.currency;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;

import application.converters.BaseUnitConverter;
import application.converters.UnitTypeConverter;

public class CurrencyConverter extends UnitTypeConverter {
	private static String baseCurrency = "Colombian Pesos";
	private static JSONObject exchangeRates = new JSONObject();
	private static Date lastUpdateDate;
	private static String internalDateString = "2023-03-19";
	private static String externalDateString = null;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private static CurrencyUnitConverter[] currencyConverters = new CurrencyUnitConverter[] {
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
			new CurrencyUnitConverter("Panamanian Balboas", "PAB", 0.000207) };

	public static void updateMULTIPLIERS() {
		if (exchangeRates == null)
			return;

		for (CurrencyUnitConverter converter : currencyConverters) {
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
			externalDateString = (String) externalData.get("date");
			connection.updateFile();
			exchangeRates = externalData.getJSONObject("rates");
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
	}

	public CurrencyConverter() {
		super(baseCurrency, currencyConverters);
		handleExternalData();
		if (exchangeRates != null) {
			updateMULTIPLIERS();
		}
		updateDate();
		getDate();
	}

	public void updateDate() {
		try {
			if (externalDateString != null) {
				Date externalDate = sdf.parse(externalDateString);
				lastUpdateDate = externalDate;
			} else {
				Date internalDate = sdf.parse(internalDateString);
				lastUpdateDate = internalDate;
			}
		} catch (JSONException | ParseException exception) {
			System.out.println(exception.getMessage());
		}
	}

	public String getDate() {
		try {
			Date today = new Date();

			// Calculate the number of days between dates
			long timeDiff = Math.abs(today.getTime() - lastUpdateDate.getTime());
			long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

			if (daysDiff == 0) {
				return "Today";
			} else if (daysDiff > 0 && daysDiff < 7) {
				return daysDiff + " days ago.";
			} else if (daysDiff == 7) {
				return "A week ago";
			} else {
				return sdf.format(lastUpdateDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getUnitType() {
		return "Currency";
	}

	@Override
	public String getIconName() {
		return "currency.png";
	}

}
