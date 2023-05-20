import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;


/**
 * Cette classe permet de parcourir un document JSON et d'y produire un "output". J'ai recherché cette classe à partir du lien
 * suivant: https://gitlab.com/sergedelil/uqam/-/blob/master/INF2050/exemples/ExempleJSON/src/main/java/domain/JSONExemple.java
 */
public class JsonInputOutput {
    private final String filename;
    private final String outputFile;
    static JSONObject jsonObj;
    static boolean isTrue=false;

    public JsonInputOutput(String filename, String outputFile){

        this.filename = filename;
        this.outputFile = outputFile;
        jsonObj = null;
    }

    public static JSONArray JSONArray() throws IOException, ParseException {
        FileReader reader = new FileReader(Main.FICHIER);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(Main.FICHIER));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray reclamations = (JSONArray) jsonObject.get("reclamations");
        return reclamations;
    }

    public void load() throws IOException, ParseException {

        Object obj = new JSONParser().parse(new FileReader(filename));
        jsonObj = (JSONObject) obj;
    }

    public void save() throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(outputFile);
        pw.write(jsonObj.toJSONString());

        pw.flush();
        pw.close();
    }

    public static void to_string(String[] remboursements, long[] soins, String[] dates) {
        String dossier = (String) jsonObj.get("dossier");
        System.out.println("client : " + dossier);


        String mois = (String) jsonObj.get("mois");
        System.out.println("mois : " + mois);

        System.out.println("remboursements :");

        JSONArray jsonArray = (JSONArray) jsonObj.get("reclamations");
        for (int i = 0; i < remboursements.length; i++) {
            System.out.println("===========================");
            System.out.println("soin : " + soins[i]);
            System.out.println("date : " + dates[i]);
            System.out.println("montant : " + remboursements[i]);
        }
        to_json(dossier, mois, remboursements, soins, dates);
    }
    public static void to_json(String dossier, String mois, String[] remboursements, long[] soins, String[] dates) {
        JSONObject mainJson = new JSONObject();
        JSONArray array = new JSONArray();
        mainJson.put("dossier", dossier);
        mainJson.put("mois", mois);
        mainJson.put("remboursements", array);
        mainJson.put("mois", mois);
        double total = 0.0; // initialize total to zero
        for (int i = 0; i < remboursements.length; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("montant", remboursements[i]);
            jsonObject.put("soin", soins[i]);
            jsonObject.put("date", dates[i]);
            array.add(jsonObject);
            // met à jour le total avec les montants de remboursements
            total += Double.parseDouble(remboursements[i].replaceAll("[^\\d.]", ""));
        }
        System.out.println("\nTotal: " + total);
        //mainJson.put("client", dossier);
        //mainJson.put("mois", mois);
       mainJson.put("remboursements", array);
        mainJson.put("total", String.format("%.2f$", total)); // ajoute le total a l'objet json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(mainJson.toJSONString());
        String prettyJsonString = gson.toJson(je);
        fileWriter(prettyJsonString);
        boolean isTrue=true;
    }

    public static void fileWriter(String prettyJsonString) {
        try {
            FileWriter file = new FileWriter(Main.FICHIER_OUTPUT);
            file.write(prettyJsonString);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





