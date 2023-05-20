//import org.json.simple.JSONObject;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
//import static org.junit.Assert.assertEquals;
//
//public class NoDossierTest {
//    @Test
//    @DisplayName("Verifier qu'un numéro de dossier invalide change la valeur de i à 3 pour imprimer un message d'erreur")
//    public void testNoDossierValide() {
//        // Préparation des données d'entrée
//        String fichier1 = "test1.json";
//
//        JSONObject json1 = new JSONObject();
//
//        String[] tab = {"A000000","E999999","B123456","D232313","C344344"};
//        for(int i=0;i< tab.length;i++){
//
//            json1.put("dossier", tab[i]);
//
//            // Écriture du fichier JSON
//            try (FileWriter file = new FileWriter(fichier1)) {
//                file.write(json1.toJSONString());
//                file.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            // Exécution de la méthode à tester
//            Validations.verifierNoDossier(fichier1);
//
//            // Vérification du résultat
//            assertEquals(0, Main.i);
//
//            // Suppression du fichier de test
//            File file = new File(fichier1);
//            file.delete();
//        }
//    }
//}
