import org.json.simple.JSONObject;

import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;


public class MessageErreur {

    public static void afficherMessageErreur(String msg, String fichier) {
        try {
            JSONObject json = new JSONObject();
            json.put("message", msg);
            FileWriter writer = new FileWriter(fichier);
            writer.write(json.toJSONString());
            writer.close();
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader(fichier));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            //Validations.VALIDER = true;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

