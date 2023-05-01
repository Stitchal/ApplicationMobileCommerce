package edu.quelis.projet;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CreationJSON {
    String nom;

    public CreationJSON(String nom){
        this.nom = nom;
        creationJSON();
    }

    public void creationJSON(){
        String apiUrl = "https://raw.githubusercontent.com/PrismarineJS/minecraft-data/master/data/pc/1.17/items.json";
        String outputFileName = nom+".json";

        try {
            // Ouvrir la connexion avec l'API
            URL url = new URL(apiUrl);
            InputStream stream = url.openStream();

            // Lire la réponse de l'API en tant que String
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Ecrire la réponse de l'API dans un fichier JSON
            FileWriter writer = new FileWriter(outputFileName);
            writer.write(response.toString());
            writer.close();

            System.out.println("La réponse de l'API a été écrite dans le fichier " + outputFileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}