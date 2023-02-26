package application.converters.currency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		String url = "https://api.exchangerate-api.com/v4/latest/COP";
		String path = "./currency.txt";
		
		/*StringBuffer data = new StringBuffer();
		try {
			File oldLogCurrencies = new File("./currency.txt");
			Scanner reader = new Scanner(oldLogCurrencies);
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				data.append(line);
				System.out.println(line);
			}
			reader.close();
			JSONObject obj = new JSONObject(data.toString());
			BigDecimal exchangeRate = (BigDecimal) obj.getJSONObject("rates").get("COP");
			System.out.println(exchangeRate);
			
		} catch (FileNotFoundException NotFoundException) {

			try {
				String GET_URL = "https://api.exchangerate-api.com/v4/latest/USD";
				URL url = new URL(GET_URL);
				HttpURLConnection request = (HttpURLConnection) url.openConnection();
				request.setRequestMethod("GET");

				if (request.getResponseCode() == HttpURLConnection.HTTP_OK) {
					InputStream im = request.getInputStream();

					BufferedReader br = new BufferedReader(new InputStreamReader(im));

					FileOutputStream newLogCurrencies = new FileOutputStream("./currency.txt");

					String line = br.readLine();
					while (line != null) {
						
						System.out.println(line);
						newLogCurrencies.write(line.getBytes());
						line = br.readLine();
						data.append(line);
						
					}
					
					br.close();
					newLogCurrencies.flush();
					newLogCurrencies.close();
					JSONObject obj = new JSONObject(data.toString());
					Double exchangeRate = (Double) obj.getJSONObject("rates").get("COP");
					System.out.println(exchangeRate);
					
				}

			} catch (Exception notCreatedFile) {

				System.out.println(notCreatedFile);

			}

		} catch (Exception unknownException) {

			System.out.println(unknownException);

		} finally {*/

	}
}
