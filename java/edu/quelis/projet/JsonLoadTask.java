package edu.quelis.projet;

import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonLoadTask extends AsyncTask<String, String, String> {
    private String filePath = "assets/data.json";
    public String apiUrl = "https://raw.githubusercontent.com/PrismarineJS/minecraft-data/master/data/pc/1.17/items.json";

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... strings) {
        // implement API in background and store the response in current variable
        String current = "";
        try {
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL(apiUrl);
                System.out.println(apiUrl);
                urlConnection = (HttpURLConnection) url
                        .openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader isw = new InputStreamReader(in);

                int data = isw.read();
                while (data != -1) {
                    current += (char) data;
                    data = isw.read();
                    //System.out.print(current);

                }
                System.out.print(current);
                // return the data to onPostExecute method
                return current;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Exception: " + e.getMessage();
        }
        return current;
    }

    protected void onPostExecute(String success) {
        Log.i(success, "");
        //attemptLogin();
    }
}

    /*
    try {
            // Faire la requête HTTP ici
            URL url = new URL(this.url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            System.out.println("Connexion ");
            conn.connect();

            // Lire la réponse ici
            InputStream inputStream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Utiliser la réponse ici
            String jsonResponse = response.toString();
            //JSONObject jsonObject = new JSONObject(jsonResponse);
            FileWriter writer = new FileWriter(filePath);
            writer.write(jsonResponse);
            writer.close();
            System.out.println("Le fichier JSON a été téléchargé et enregistré avec succès.");


            // ...
        } catch (Exception e) {
            e.printStackTrace();
        }
     */