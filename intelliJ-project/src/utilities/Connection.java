package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class Connection {
    private String url = "https://api.exchangerate-api.com/v4/latest/COP";
    private String path = "./currency.txt";
    private static JSONObject jsonFromFile = new JSONObject();
    private static JSONObject jsonFromAPI = new JSONObject();

    public JSONObject getExternalData() throws FileNotFoundException, IOException {
        File logInComputer = new File(this.path);
        if (logInComputer.exists()) {
            jsonFromFile = getJSONFromFile(logInComputer);
            if (isFileUpToDate()) {
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
        try {
            FileWriter writerObj = new FileWriter(this.path, false);
            writerObj.write(json.toString());
            writerObj.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isFileUpToDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date today = new Date();
            Date dateInFile = sdf.parse((String) jsonFromFile.get("date"));

            return sdf.format(today).equals(sdf.format(dateInFile));

        } catch (JSONException | ParseException exception) {
            return false;
        }

    }

    public void updateFile() {

        if (jsonFromAPI.isEmpty()) return;

        if (jsonFromFile.isEmpty() && isFileUpToDate()) return;

        writeFileFromJSON(jsonFromAPI);
    }

}

// MalformedURLException
// IOException