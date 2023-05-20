import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ValidationsTest {

    @Test
    @DisplayName("Test changeant la valeur de i a 3 lorsque contrat invalide et conserve i = 0 quand contrat valide")
    public void testValiderTypeContrat() {

        // Cas invalide : dossier ne contient aucun type de contrat valide
        String dossierInvalide0 = "F1234";
        String dossierInvalide1 = "Z1234";

        assertDoesNotThrow(() -> Validations.validerTypeContrat(dossierInvalide0));
        assertDoesNotThrow(() -> Validations.validerTypeContrat(dossierInvalide1));

        assertEquals(3, Main.i); // i doit être mis à 3
    }

    @Test
    @DisplayName("Verifier que la valeur de i reste égale à 0 quand le soin est valide")
    public void testNoDossierInvalide() {
        // Préparation des données d'entrée
        String fichier1 = "test1.json";

        JSONObject json1 = new JSONObject();

        String[] tab = {"a000000", "!43R33", "F000000", "A1234", "ZE"};
        for (int i = 0; i < tab.length; i++) {

            json1.put("dossier", tab[i]);

            // Écriture du fichier JSON
            try (FileWriter file = new FileWriter(fichier1)) {
                file.write(json1.toJSONString());
                file.flush();

                // Exécution de la méthode à tester
                Validations.verifierNoDossier(fichier1);

                // Vérification du résultat
                assertEquals(3, Main.i);

            } catch (IOException e) {
                e.printStackTrace();
            }

            File file = new File(fichier1);
            file.delete();
        }


    }


    @Test
    @DisplayName("Verifier que le boolean est true quand le soin et valide et false quand le soin est invalide")
    public void testVerifierSoinValideEtInvalide() throws IOException, ParseException {
        long soin = 0;
        boolean estSoinValide = false;
        // Exécution de la méthode à tester
        estSoinValide = Validations.verifierSoinValide(soin, estSoinValide);

        // Vérification du résultat
        assertTrue(estSoinValide);

        soin = 700;
        estSoinValide = false;
        // Exécution de la méthode à tester
        estSoinValide = Validations.verifierSoinValide(soin, estSoinValide);

        // Vérification du résultat
        assertTrue(estSoinValide);


        estSoinValide = false;
        soin = 124;
        // Exécution de la méthode à tester
        estSoinValide = Validations.verifierSoinValide(soin, estSoinValide);

        // Vérification du résultat
        assertFalse(estSoinValide);

        estSoinValide = false;
        soin = 701;
        // Exécution de la méthode à tester
        estSoinValide = Validations.verifierSoinValide(soin, estSoinValide);

        // Vérification du résultat
        assertFalse(estSoinValide);

        estSoinValide = false;
        soin = -1;
        // Exécution de la méthode à tester
        estSoinValide = Validations.verifierSoinValide(soin, estSoinValide);

        // Vérification du résultat
        assertFalse(estSoinValide);

    }

    //
//
    @Test
    @DisplayName("Verifier que la variable retournée par la méthode soit le contrat de valeur A")
    public void testRecupererContratType() throws IOException, ParseException {

        // Préparation des données d'entrée
        String fichier = "test.json";
        JSONObject json = new JSONObject();
        json.put("dossier", "A");

        // Écriture du fichier JSON
        try (FileWriter file = new FileWriter(fichier)) {
            file.write(json.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exécution de la méthode à tester
        String contrat = Validations.recupererTypeContrat(fichier);

        // Vérification du résultat
        assertEquals("A", contrat);

        // Suppression du fichier de test
        File file = new File(fichier);
        file.delete();
    }

    @Test
    @DisplayName("Verifier que la valeur de i reste égale à 0 quand le soin est valide")
    public void testSoinValide() throws IOException, ParseException {
        long[] tab = new long[1];
        tab[0] = 2098;
        //Exécution de la méthode à tester
        Validations.validSoin(tab);
        // Vérification du résultat
        assertEquals(4, Main.i);
    }
}







