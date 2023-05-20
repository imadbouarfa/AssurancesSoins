import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONObject;
import java.io.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ContratsTest {

    double unMontant;
    double rabaisMax;
    double resultat;
    double vraiResultat;



    @Test
    @DisplayName("Test pour rabais de 70%")
    public void testCalculRabais70() {
        //Test avec un montant positif
        unMontant = 100.0;
        resultat = 70.0;
        vraiResultat = Contrats.calculRabais70(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un montant négatif
        unMontant = -100.0;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais70(unMontant));

        //Test avec un montant de zero
        unMontant = 0.0;
        resultat = 0.0;
        vraiResultat = Contrats.calculRabais70(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);
    }


    @Test
    @DisplayName("Test pour rabais de 100%")
    public void testCalculRabais100() {
        //Test avec un montant positif
        unMontant = 100.0;
        rabaisMax = 50.0;
        resultat = 50.0;
        vraiResultat = Contrats.calculRabais100(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un montant négatif
        unMontant = -100.0;
        rabaisMax = 50;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais100(unMontant, rabaisMax));

        //Test avec un montant de zero
        unMontant = 0.0;
        resultat = 0.0;
        rabaisMax = 50;
        vraiResultat = Contrats.calculRabais100(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un rabais max de zero
        unMontant = 100.0;
        resultat = 100.0;
        rabaisMax = 0;
        vraiResultat = Contrats.calculRabais100(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un rabais max négatif
        unMontant = 100.0;
        rabaisMax = -50;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais100(unMontant, rabaisMax));
    }

    @Test
    @DisplayName("Test pour rabais de 50%")
    public void testCalculRabais50() {
        //Test avec un montant positif
        unMontant = 200.0;
        rabaisMax = 50.0;
        resultat = 50.0;
        vraiResultat = Contrats.calculRabais50(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un montant négatif
        unMontant = -100.0;
        rabaisMax = 50;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais50(unMontant, rabaisMax));

        //Test avec un montant de zero
        unMontant = 0.0;
        resultat = 0.0;
        rabaisMax = 50;
        vraiResultat = Contrats.calculRabais50(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un rabais max de zero
        unMontant = 100.0;
        resultat = 50.0;
        rabaisMax = 0;
        vraiResultat = Contrats.calculRabais50(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un rabais max négatif
        unMontant = 100.0;
        rabaisMax = -50;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais50(unMontant, rabaisMax));
    }

    @Test
    @DisplayName("Test pour rabais de 75%")
    public void testCalculRabais75() {
        //Test avec un montant positif
        unMontant = 100.0;
        resultat = 75.0;
        vraiResultat = Contrats.calculRabais75(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un montant négatif
        unMontant = -100.0;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais75(unMontant));

        //Test avec un montant de zero
        unMontant = 0.0;
        resultat = 0.0;
        vraiResultat = Contrats.calculRabais75(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);
    }

    @Test
    @DisplayName("Test pour rabais de 95%")
    public void testCalculRabais95() {
        //Test avec un montant positif
        unMontant = 100.0;
        resultat = 95.0;
        vraiResultat = Contrats.calculRabais95(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un montant négatif
        unMontant = -100.0;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais95(unMontant));

        //Test avec un montant de zero
        unMontant = 0.0;
        resultat = 0.0;
        vraiResultat = Contrats.calculRabais95(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);
    }

    @Test
    @DisplayName("Test pour rabais de 15%")
    public void testCalculRabais15() {
        //Test avec un montant positif
        unMontant = 100.0;
        resultat = 15.0;
        vraiResultat = Contrats.calculRabais15(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un montant négatif
        unMontant = -100.0;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais15(unMontant));

        //Test avec un montant de zero
        unMontant = 0.0;
        resultat = 0.0;
        vraiResultat = Contrats.calculRabais15(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);
    }

    @Test
    @DisplayName("Test pour rabais de 25%")
    public void testCalculRabais25() {
        //Test avec un montant positif
        unMontant = 100.0;
        rabaisMax = 10.0;
        resultat = 10.0;
        vraiResultat = Contrats.calculRabais25(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un montant négatif
        unMontant = -100.0;
        rabaisMax = 50;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais25(unMontant, rabaisMax));

        //Test avec un montant de zero
        unMontant = 0.0;
        resultat = 0.0;
        rabaisMax =50;
        vraiResultat = Contrats.calculRabais25(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un rabais max de zero
        unMontant = 100.0;
        resultat = 25.0;
        rabaisMax = 0;
        vraiResultat = Contrats.calculRabais25(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un rabais max négatif
        unMontant = 100.0;
        rabaisMax = -50;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais25(unMontant, rabaisMax));
    }

    @Test
    @DisplayName("Test pour rabais de 12%")
    public void testCalculRabais12() {
        //Test avec un montant positif
        unMontant = 100.0;
        resultat = 12.0;
        vraiResultat = Contrats.calculRabais12(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un montant négatif
        unMontant = -100.0;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais12(unMontant));

        //Test avec un montant de zero
        unMontant = 0.0;
        resultat = 0.0;
        vraiResultat = Contrats.calculRabais12(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);
    }

    @Test
    @DisplayName("Test pour rabais de 60%")
    public void testCalculRabais60() {
        //Test avec un montant positif
        unMontant = 100.0;
        resultat = 60.0;
        vraiResultat = Contrats.calculRabais60(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un montant négatif
        unMontant = -100.0;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais60(unMontant));

        //Test avec un montant de zero
        unMontant = 0.0;
        resultat = 0.0;
        vraiResultat = Contrats.calculRabais60(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);
    }

    @Test
    @DisplayName("Test pour rabais de 30%")
    public void testCalculRabais30() {
        //Test avec un montant positif
        unMontant = 100.0;
        rabaisMax = 20.0;
        resultat = 20.0;
        vraiResultat = Contrats.calculRabais30(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un montant négatif
        unMontant = -100.0;
        rabaisMax = 50;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais30(unMontant, rabaisMax));

        //Test avec un montant de zero
        unMontant = 0.0;
        resultat = 0.0;
        rabaisMax =50;
        vraiResultat = Contrats.calculRabais30(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un rabais max de zero
        unMontant = 100.0;
        resultat = 30.0;
        rabaisMax = 0;
        vraiResultat = Contrats.calculRabais30(unMontant, rabaisMax);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un rabais max négatif
        unMontant = 100.0;
        rabaisMax = -50;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais30(unMontant, rabaisMax));
    }

    @Test
    @DisplayName("Test pour rabais de 22%")
    public void testCalculRabais22() {
        //Test avec un montant positif
        unMontant = 100.0;
        resultat = 22.0;
        vraiResultat = Contrats.calculRabais22(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);

        //Test avec un montant négatif
        unMontant = -100.0;
        assertThrows(IllegalArgumentException.class, () -> Contrats.calculRabais22(unMontant));

        //Test avec un montant de zero
        unMontant = 0.0;
        resultat = 0.0;
        vraiResultat = Contrats.calculRabais22(unMontant);
        assertEquals(resultat, vraiResultat, 0.001);
    }

    @Test
    @DisplayName("Test pour le contrat A")
    void testContratA() throws IOException, ParseException, org.json.simple.parser.ParseException {
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

        double unMontant = 1000.0;
        double[] attendu = {250.0, 350.0, 0.0, 250.0, 0.0, 0.0, 250.0, 400.0, 0.0};

        long[] soin = {0,100, 150, 200,300, 400, 500, 600, 700};
        for(int i=0;i< soin.length;i++) {

            double obtenu = Contrats.contratA(soin[i], unMontant, fichier);
            Assertions.assertEquals(attendu[i], obtenu);
        }
        // Suppression du fichier de test
        File file = new File(fichier);
        file.delete();
    }
    @Test
    @DisplayName("Test pour le contrat B")
    void testContratB() throws IOException, ParseException, org.json.simple.parser.ParseException {
        String fichier = "test.json";
        JSONObject json = new JSONObject();
        json.put("dossier", "B");

        // Écriture du fichier JSON
        try (FileWriter file = new FileWriter(fichier)) {
            file.write(json.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double unMontant = 1000.0;
        double[] attendu = {500.0, 500.0, 0.0, 750.0, 1000.0, 500.0, 0.0, 500.0, 1000.0, 700.0};

        long[] soin = {0,100, 150, 175, 200, 300, 400, 500, 600, 700};
        for(int i=0;i< soin.length;i++) {

            double obtenu = Contrats.contratB(soin[i], unMontant, fichier);
            Assertions.assertEquals(attendu[i], obtenu);
        }
        // Suppression du fichier de test
        File file = new File(fichier);
        file.delete();
    }

    @Test
    @DisplayName("Test pour le contrat C")
    void testContratC() throws IOException, ParseException, org.json.simple.parser.ParseException {
        String fichier = "test.json";
        JSONObject json = new JSONObject();
        json.put("dossier", "C");

        // Écriture du fichier JSON
        try (FileWriter file = new FileWriter(fichier)) {
            file.write(json.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double unMontant = 1000.0;
        double[] attendu = {900.0, 950.0, 850.0, 900.0, 900.0, 900.0, 900.0, 900.0, 750.0, 900.0};

        long[] soin = {0,100, 150, 175, 200, 300, 400, 500, 600, 700};
        for(int i=0;i< soin.length;i++) {

            double obtenu = Contrats.contratC(soin[i], unMontant, fichier);
            Assertions.assertEquals(attendu[i], obtenu);
        }
        // Suppression du fichier de test
        File file = new File(fichier);
        file.delete();
    }

    @Test
    @DisplayName("Test pour le contrat D")
    void testContratD() throws IOException, ParseException, org.json.simple.parser.ParseException {
        String fichier = "test.json";
        JSONObject json = new JSONObject();
        json.put("dossier", "D");

        // Écriture du fichier JSON
        try (FileWriter file = new FileWriter(fichier)) {
            file.write(json.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double unMontant = 1000.0;
        double[] attendu = {1000.0, 1000.0, 1000.0, 950.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0, 1000.0};

        long[] soin = {0,100, 150, 175, 200, 300, 400, 500, 600, 700};
        for(int i=0;i< soin.length;i++) {

            double obtenu = Contrats.contratD(soin[i], unMontant, fichier);
            Assertions.assertEquals(attendu[i], obtenu);
        }
        // Suppression du fichier de test
        File file = new File(fichier);
        file.delete();
    }

    @Test
    @DisplayName("Test pour le contrat E")
    void testContratE() throws IOException, ParseException, org.json.simple.parser.ParseException {
        String fichier = "test.json";
        JSONObject json = new JSONObject();
        json.put("dossier", "E");

        // Écriture du fichier JSON
        try (FileWriter file = new FileWriter(fichier)) {
            file.write(json.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double unMontant = 1000.0;
        double[] attendu = {150.0, 250.0, 150.0, 250.0, 120.0, 600.0, 250.0, 300.0, 150.0, 220.0};

        long[] soin = {0,100, 150, 175, 200, 300, 400, 500, 600, 700};
        for(int i=0;i< soin.length;i++) {

            double obtenu = Contrats.contratE(soin[i], unMontant, fichier);
            Assertions.assertEquals(attendu[i], obtenu);
        }
        // Suppression du fichier de test
        File file = new File(fichier);
        file.delete();
    }
}
