package Task4;

import java.io.*;
import java.net.*;
import org.json.*;

public class CurrencyConverter {
    private static final String API_KEY = "935c79d42746b6b2b8803d10";
    private static final String API_URL ="https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public static void main(String[] args)
    {
        try {
            BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the base currency - example: EUR - ");
            String bCurrency = scan.readLine().toUpperCase();
            System.out.println("Enter the target currency - example: USD - ");
            String tCurrency = scan.readLine().toUpperCase();
            System.out.println("Enter the amount (optional): ");
            String amountS = scan.readLine();
            double amount = amountS.isEmpty() ? 1 : Double.parseDouble(amountS);

            URL url = new URL(API_URL + bCurrency + "/" + tCurrency + "/" + amount);
            HttpURLConnection req = (HttpURLConnection) url.openConnection();
            req.connect();;

            BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null)
                response.append(line);
            reader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            String reqResult = jsonObject.getString("result");

            if(reqResult.equals("success"))
            {
                double convRate = jsonObject.getDouble("conversion_rate");
                double convResult = jsonObject.getDouble("conversion_result");
                System.out.println("Conversion rate from " + bCurrency + " to " + tCurrency + " : " + convRate);
                System.out.println("Conversion result : " + convResult);
            }
            else {
                System.out.println("Error: " + jsonObject.getString("error-type"));
            }
        } catch (IOException | JSONException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}