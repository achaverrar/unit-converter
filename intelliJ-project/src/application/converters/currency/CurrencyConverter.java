package application.converters.currency;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;

import application.converters.UnitTypeConverter;
import utilities.Connection;

public class CurrencyConverter extends UnitTypeConverter {
    private static String baseCurrency = "Pesos Colombianos";
    private static JSONObject exchangeRates = new JSONObject();
    private static Date lastUpdateDate;
    private static String internalDateString = "2023-03-20";
    private static String externalDateString = null;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static CurrencyUnitConverter[] currencyConverters = new CurrencyUnitConverter[] {
            new CurrencyUnitConverter("Pesos Colombianos", "COP", 1.0),
            new CurrencyUnitConverter("Pesos Argentinos", "ARS", 0.0419),
            new CurrencyUnitConverter("Reales Brasileños", "BRL", 0.00109),
            new CurrencyUnitConverter("Pesos Chilenos", "CLP", 0.17),
            new CurrencyUnitConverter("Colones Costarricenses", "CRC", 0.113),
            new CurrencyUnitConverter("Pesos Dominicanos", "DOP", 0.0113),
            new CurrencyUnitConverter("Euros", "EUR", 0.000193),
            new CurrencyUnitConverter("Libras Esterlinas", "GBP", 0.000169),
            new CurrencyUnitConverter("Quetzal Guatemalteco", "GTQ", 0.00161),
            new CurrencyUnitConverter("Lempiras Hondureños", "HNL", 0.00508),
            new CurrencyUnitConverter("Yenes", "JPY", 0.0272),
            new CurrencyUnitConverter("Wons Surcoreanos", "KRW", 0.27),
            new CurrencyUnitConverter("Pesos Mexicanos", "MXN", 0.00388),
            new CurrencyUnitConverter("Dolares Estadounidenses", "USD", 0.000206),
            new CurrencyUnitConverter("Soles (Peruanos)", "PEN", 0.000783),
            new CurrencyUnitConverter("Balboas", "PAB", 0.000206) };

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
        if (!exchangeRates.isEmpty()) {
            updateMULTIPLIERS();
        }
        updateDate();
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
                return "Hoy";
            } else if (daysDiff == 1) {
                return "Ayer";
            } else if (daysDiff > 1 && daysDiff < 7) {
                return "Hace " + daysDiff + " días";
            } else if (daysDiff == 7) {
                return "Hace una semana";
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
        return "Divisas";
    }

    @Override
    public String getIconName() {
        return "currency.png";
    }

}