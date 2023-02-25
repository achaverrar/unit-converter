package application.converters.currency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Connection {
	private StringBuffer data;
	//private String path="./currency.txt";
	private String path="./currncy.txt";
	private String url="https://api.exchangerate-api.com/v4/latest/USD";

	public Connection() {
		data = new StringBuffer();
		try {
			JSONObject obj = getJSONFromFile();
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

					//FileOutputStream newLogCurrencies = new FileOutputStream("./currency.txt");

					String line = br.readLine();
					while (line != null) {

						System.out.println(line);
						//newLogCurrencies.write(line.getBytes());
						line = br.readLine();
						data.append(line);

					}

					br.close();
					//newLogCurrencies.flush();
					//newLogCurrencies.close();
					JSONObject obj = new JSONObject(data.toString());
					BigDecimal exchangeRate = (BigDecimal) obj.getJSONObject("rates").get("COP");
					System.out.println(exchangeRate);

				}

			} catch (Exception notCreatedFile) {

				System.out.println(notCreatedFile);

			}

		} catch (Exception unknownException) {

			System.out.println(unknownException);

		} finally {
		}

	}

	public Connection(String url, String path) {
		this.path = path;
		this.url = url;
		this.data = new StringBuffer();
	}

	public JSONObject getData() throws IOException {
		JSONObject json = new JSONObject();
		try {
			json = getJSONFromFile();
		} catch (FileNotFoundException notFoundException) {
			json = getJSONFromURL();
		}
		return json;
	}

	private JSONObject getJSONFromFile() throws FileNotFoundException {
		File oldLogCurrencies = new File(this.path);
		boolean isFile = oldLogCurrencies.isFile();
		if(!isFile) {
			throw new FileNotFoundException();
		}
		Scanner reader = new Scanner(oldLogCurrencies);

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			this.data.append(line);
		}

		reader.close();
		JSONObject json = new JSONObject(this.data.toString());
		return json;
	}

	private JSONObject getJSONFromURL() throws IOException {
		JSONObject json = new JSONObject();
		URL url = new URL(this.url);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		request.setRequestMethod("GET");
		if (request.getResponseCode() == HttpURLConnection.HTTP_OK) {
			InputStream im = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(im));

			System.out.println(url);
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				this.data.append(line);
				line = br.readLine();
			}

			br.close();
			json = new JSONObject(this.data.toString());
		}
		return json;
	}

	private void writeFileFromJSON() {

	}

	private void getDataFromJSON() {

	}
}

// MalformedURLException
// IOException
