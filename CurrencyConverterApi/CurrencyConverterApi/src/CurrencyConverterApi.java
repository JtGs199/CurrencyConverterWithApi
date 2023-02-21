import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class CurrencyConverterApi {

    //add the website link
    private static final String API_URL = "https://openexchangerates.org/api/latest.json?app_id=ead667b162ef44d4895a871ebf3169be";

    public static void main(String[] args) {
        try {
            // take input from user
            Scanner in = new Scanner(System.in);
            // take ammount to be converted
            System.out.print("Enter the amount to convert: ");
            double amount = in.nextDouble();
            // take the currency to convert
            System.out.print("Enter the source currency (e.g. USD, EUR, GBP): ");
            String from = in.next();
            // take the currency to convert to
            System.out.print("Enter the target currency (e.g. USD, EUR, GBP): ");
            String to = in.next();
            in.close();

            // call method to get data from website
            String response = sendGetRequest(API_URL);
            // save rate in json object
            JSONObject exchangeRates = new JSONObject(response).getJSONObject("rates");
            double rate = exchangeRates.getDouble(to) / exchangeRates.getDouble(from);

            // calculate the the converted ammount
            double convertedAmount = amount * rate;
            // print result
            System.out.println(amount + " " + from + " is equivalent to " + convertedAmount + " " + to);
            // catch any error and print what it is
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static String sendGetRequest(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        // connect website with program
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        /*int responseCode = con.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("Failed to get exchange rates (response code " + responseCode + ")");
        }*/

        // read info from website
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        // store inout from website
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // return info
        return response.toString();
    }
}


