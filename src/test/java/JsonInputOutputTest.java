import org.json.simple.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class JsonInputOutputTest {

    private static final String INPUT_FILE = "input";
    private static final String OUTPUT_FILE = "src/output.json";

    @Test
    @DisplayName("Verifie le fichier JSON a charger")
    public void testLoad() throws IOException, ParseException {
        // Create un fichier temporaire avec des donnees
        File tempFile = File.createTempFile("test", ".json");
        FileWriter writer = new FileWriter(tempFile);
        writer.write("{\"dossier\": \"1234567890\", \"mois\": \"janvier\", \"reclamations\": []}");
        writer.close();

        // Cree une instance de la classe et charge les donnees du fichier temporaire
        JsonInputOutput jsonIO = new JsonInputOutput(tempFile.getAbsolutePath(), null);
        jsonIO.load();

        // Assure que le fichier json contient les bonnes donnees
        JSONObject jsonObj = JsonInputOutput.jsonObj;
        assertNotNull(jsonObj);
        assertEquals("1234567890", jsonObj.get("dossier"));
        assertEquals("janvier", jsonObj.get("mois"));
        assertNotNull(jsonObj.get("reclamations"));

        // Supprime le fichier temporaire
        tempFile.delete();
    }




    @Test
    @DisplayName("Verifie que le fichier sauvegarde correctement")
    public void testSave() throws IOException, ParseException {
        JsonInputOutput jsonIO = new JsonInputOutput(INPUT_FILE, OUTPUT_FILE);
        jsonIO.load();
        JSONObject jsonObj = JsonInputOutput.jsonObj;
        jsonIO.save();
        // Verifie que le output a ete cree
        File outputFile = new File(OUTPUT_FILE);
        assertTrue(outputFile.exists());
        // Verifie que le contenu du fichier output est correct
        JsonInputOutput jsonIO2 = new JsonInputOutput(OUTPUT_FILE, OUTPUT_FILE);
        jsonIO2.load();
        JSONObject jsonObj2 = JsonInputOutput.jsonObj;
        assertEquals(jsonObj.toJSONString(), jsonObj2.toJSONString());
        // Nettoie le fichier output
        outputFile.delete();
    }

    @Test
    void testSaveThrowsFileNotFoundException() {
        JsonInputOutput jsonInputOutput = new JsonInputOutput("", "");
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            jsonInputOutput.save();
        });
    }

    @Test
    void testJSONArrayNullPointerException() {
        JsonInputOutput jsonInputOutput = new JsonInputOutput("", "");
        Assertions.assertThrows(NullPointerException.class, () -> {
            JSONArray jsonArray = jsonInputOutput.JSONArray();
        });
    }

    @Test
    void to_jsontest()  {
        String [] remboursements = {""};
        String mois = "02";
        String dossier = "A123";
        String []dates = {"2021-03", "2023-05"};
        long []soins = {100, 200, 300, 400};
        Assertions.assertThrows(NumberFormatException.class, () -> JsonInputOutput.to_json(dossier, mois, remboursements, soins, dates));
    }


    @Test
    public void testToStringSingleRemboursement() {
        // Entrées simulées
        String[] remboursements = {"50.00"};
        long[] soins = {1234};
        String[] dates = {"2023-04-23"};

        // Sortie attendue
        String expectedOutput = "client : \nmois : \nremboursements :\n===========================\nsoin : 1234\ndate : 2023-04-23\nmontant : 50.00\n";

        assertThrows(NullPointerException.class, () -> JsonInputOutput.to_string(remboursements, soins, dates));
    }
}


