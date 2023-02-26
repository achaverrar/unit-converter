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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONObject;

public class Connection {
	private StringBuffer data;
	// private String path="./currency.txt";
	private String path = "./currncy.txt";
	private String url = "https://api.exchangerate-api.com/v4/latest/USD";

	public Connection() {
		data = new StringBuffer();

		try {
			String GET_URL = "https://api.exchangerate-api.com/v4/latest/USD";
			URL url = new URL(GET_URL);
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			request.setRequestMethod("GET");

			if (request.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream im = request.getInputStream();

				BufferedReader br = new BufferedReader(new InputStreamReader(im));

				// FileOutputStream newLogCurrencies = new FileOutputStream("./currency.txt");

				String line = br.readLine();
				while (line != null) {

					System.out.println(line);
					// newLogCurrencies.write(line.getBytes());
					line = br.readLine();
					data.append(line);

				}

				br.close();
				// newLogCurrencies.flush();
				// newLogCurrencies.close();
				JSONObject obj = new JSONObject(data.toString());
				BigDecimal exchangeRate = (BigDecimal) obj.getJSONObject("rates").get("COP");
				System.out.println(exchangeRate);

			}

		} catch (Exception notCreatedFile) {

			System.out.println(notCreatedFile);

		}
	}

	public Connection(String url, String path) {
		this.path = path;
		this.url = url;
		this.data = new StringBuffer();
	}

	public JSONObject getExternalData() throws FileNotFoundException, IOException {
		File logInComputer = new File(this.path);
		JSONObject jsonFromFile, jsonFromAPI;
		if (logInComputer.exists()) {
			jsonFromFile = getJSONFromFile(logInComputer);
			String dateFromFile = jsonFromFile.get("date").toString();
			if (isDateToday(dateFromFile)) {
				return jsonFromFile;
			} else {
				try {
					jsonFromAPI = getJSONFromAPI();
					return jsonFromAPI;
				} catch (IOException e) {
					return jsonFromFile;
				}
			}
		} else {
			jsonFromAPI = getJSONFromAPI();
			return jsonFromAPI;
		}
	}

	private JSONObject getJSONFromFile(File file) throws FileNotFoundException {
		StringBuffer dataFromFile = new StringBuffer();
		Scanner reader = new Scanner(file);

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			dataFromFile.append(line);
		}

		reader.close();
		JSONObject json = new JSONObject(dataFromFile.toString());
		return json;
	}

	private JSONObject getJSONFromAPI() throws IOException {
		StringBuffer dataFromAPI = new StringBuffer();
		JSONObject json = new JSONObject();
		URL url = new URL(this.url);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		request.setRequestMethod("GET");
		if (request.getResponseCode() == HttpURLConnection.HTTP_OK) {
			InputStream im = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(im));

			String line = br.readLine();
			while (line != null) {
				dataFromAPI.append(line);
				line = br.readLine();
			}

			br.close();
			json = new JSONObject(dataFromAPI.toString());
		}
		return json;
	}

	public void writeFileFromJSON(JSONObject json) {

	}

	public boolean isDateToday(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		try {
			Date dateToCheck = sdf.parse(date);
			return sdf.format(today).equals(sdf.format(dateToCheck));
		} catch (ParseException e) {
			return false;
		}
	}

}

// MalformedURLException
// IOException
