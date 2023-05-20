import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;
import java.io.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;




public class MoisTest {
    @AfterEach
    public void cleanup() {
        // Supprimer les fichiers après chaque test
        File file1 = new File("test.json");
        File file2 = new File("test2.json");
        file1.delete();
        file2.delete();
    }
//    @Test
//    @DisplayName ("vérifie qu'aucune erreur n'est affichée lorsque la date est formatée correctement, et inversement")
//    public void testValiderMois(){
//        String fichier2 = "test.json";
//        JSONObject json = new JSONObject();
//        json.put("mois", "2023-01");
//
//        // Écriture du fichier JSON
//        try (FileWriter file = new FileWriter(fichier2)) {
//            file.write(json.toJSONString());
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Validations.validerMois(fichier2);
//        assertEquals(0, Main.i);
//        String fichier3 = "test2.json";
//        JSONObject json2 = new JSONObject();
//        json2.put("mois", "20283-912");
//
//        // Écriture du fichier JSON
//        try (FileWriter file = new FileWriter(fichier3)) {
//            file.write(json2.toJSONString());
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Validations.validerMois(fichier3);
//        assertEquals(1, Main.i);
//    }

}
