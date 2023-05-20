import net.sf.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class StatistiquesTest {

    File fichierTest = new File("statstest.txt");

    @After
    public void supprimerFichierTest() {
        if (fichierTest.exists()) {
            fichierTest.delete();
        }
    }
    @Test
   void testsave() {
        Statistiques test = new Statistiques ("statstest.txt");
        assertDoesNotThrow(() -> test.save());

    }



    @Test
    public void testUpdateStatsParseException() throws IOException, ParseException {
        Statistiques test = new Statistiques ("statstest.txt");
        File tempFile = File.createTempFile("stest", ".txt");
        try {

            FileWriter writer = new FileWriter(tempFile);
            writer.write(" ");
            writer.close();


            assertThrows(ParseException.class, () -> test.updateStats(tempFile.getAbsolutePath()));
        } finally {
            tempFile.delete();
        }
    }

    @Test
    public void testVerifierReclamationsValidesNull() throws IOException, ParseException {
        Statistiques test = new Statistiques ("statstest.txt");
        JSONArray reclamations = null;
        assertThrows(NullPointerException.class, () -> test.verifierReclamationsValides(reclamations));
    }

    @Test
    public void testLoad() {
        Statistiques test = new Statistiques ("statstest.txt");
        assertDoesNotThrow(() -> {
            test.load();
        });
    }

    @Test
    public void testResetStats() {
        Statistiques test = new Statistiques ("statstest.txt");
        test.resetStats();

        // Vérifier que les variables ont été réinitialisées
        assertEquals(0, test.getStats());
        assertEquals(0, test.getStatsRefus());
        assertEquals(0, test.getStatsType());
    }

}


