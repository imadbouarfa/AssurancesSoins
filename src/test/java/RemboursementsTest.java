import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class RemboursementsTest {

    @Test
    public void testTabRemboursThrowsException() throws IOException, ParseException {
        Remboursements remboursements = new Remboursements();
        long[] soins = {100};
        int[] tabMontant = {100};
        String contrat = "A";
        String fichier = "fichier.json";
        double remboursement = 0.0;
        Assertions.assertThrows(NullPointerException.class, () -> {
            remboursements.tabRembours(contrat, null, tabMontant, remboursement, fichier);
        });
    }

    @Test
    public void testTabRemboursThrowsIOException() throws IOException, ParseException {
        Remboursements remboursements = new Remboursements();
        long[] soins = {200, 300};
        int[] tabMontant = {100, 800};
        String contrat = "C";
        String fichier = "";
        double remboursement = 0.0;
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            remboursements.tabRembours(contrat, soins, tabMontant, remboursement, fichier);
        });
    }


    @Test
    @DisplayName("S'assure que le contrat A calcule les bons remboursements")
    void testContratA() throws IOException, ParseException, java.text.ParseException {
        File tempFile = File.createTempFile("test", ".txt");
        try {
            // Données à écrire dans fichier temporaire
            FileWriter writer = new FileWriter(tempFile);
            writer.write("{\"dossier\":\"A123456\"}");
            writer.close();


            long soin = 100;
            int unMontant = 100;
            double attendu = 35;
            double delta = 0.001;
            double obtenu = Contrats.contratA(soin, unMontant, tempFile.getAbsolutePath());
            assertEquals(attendu, obtenu, delta);

            soin = 200;
            unMontant = 100;
            attendu = 25;
            obtenu = Contrats.contratA(soin, unMontant, tempFile.getAbsolutePath());
            assertEquals(attendu, obtenu, delta);

            soin = 300;
            unMontant = 100;
            attendu = 0;
            obtenu = Contrats.contratA(soin, unMontant, tempFile.getAbsolutePath());
            assertEquals(attendu, obtenu, delta);

            soin = 400;
            unMontant = 100;
            attendu = 0;
            obtenu = Contrats.contratA(soin, unMontant, tempFile.getAbsolutePath());
            assertEquals(attendu, obtenu, delta);

        } finally {
            tempFile.delete();
        }
    }

    @Test
    void testContratC() throws IOException, ParseException, java.text.ParseException {
        File tempFile = File.createTempFile("test", ".txt");
        try {
            // Données à écrire dans fichier temporaire
            FileWriter writer = new FileWriter(tempFile);
            writer.write("{\"dossier\":\"C123456\"}");
            writer.close();

            long soin = 100;
            int unMontant = 100;
            double attendu = 95;
            double delta = 0.001;
            double obtenu = Contrats.contratC(soin, unMontant, tempFile.getAbsolutePath());
            assertEquals(attendu, obtenu, delta);

            soin = 200;
            unMontant = 100;
            attendu = 90;
            obtenu = Contrats.contratC(soin, unMontant, tempFile.getAbsolutePath());
            assertEquals(attendu, obtenu, delta);

            soin = 300;
            unMontant = 100;
            attendu = 90;
            obtenu = Contrats.contratC(soin, unMontant, tempFile.getAbsolutePath());
            assertEquals(attendu, obtenu, delta);

            soin = 400;
            unMontant = 100;
            attendu = 90;
            obtenu = Contrats.contratC(soin, unMontant, tempFile.getAbsolutePath());
            assertEquals(attendu, obtenu, delta);

        } finally {
            tempFile.delete();
        }
    }
}
