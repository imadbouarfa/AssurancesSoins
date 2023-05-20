import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TableauxMontantsTest {
    @Test
    @DisplayName("Retourne les bons montants")
    void testObtenirMontant() throws IOException, ParseException {
        String montantsTest = "[{\"montant\": \"200$\"},{\"montant\": \"100$\"},]";
        JSONParser jsonParser = new JSONParser();
        JSONArray reclamations = (JSONArray) jsonParser.parse(montantsTest);
        //montants maintenant affichés en cents après être passés par la classe monnaie
        int[] attendu = {20000, 10000};
        int[] obtenu = TableauxMontants.obtenirMontant(reclamations);
        assertArrayEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("Lanceu une ParseException si le fichier json est incorrect")
    void testParseObtenirMontant() throws ParseException, IOException {
        //pas de signe de dollar
        String montantsTest = "[{\"montant\": \"10\"}]";
        JSONParser jsonParser = new JSONParser();
        JSONArray reclamations = null;
        try {
            reclamations = (JSONArray) jsonParser.parse(montantsTest);
        } catch (ParseException e) {
            //final pour expression lambda dans assertThrows
            JSONArray finalReclamations = reclamations;
            assertThrows(ParseException.class, () -> TableauxMontants.obtenirSoin(finalReclamations));
        }
    }


    @Test
    @DisplayName("Retourne les bons types de soin")
    void testObtenirSoin() throws ParseException, IOException {
        String soinTest = "[{\"soin\": 0},{\"soin\": 100},{\"soin\": 150},{\"soin\": 175},{\"soin\": 300},{\"soin\": 400}," +
                "{\"soin\": 500},{\"soin\": 600},{\"soin\": 700}]";
        JSONParser jsonParser = new JSONParser();
        JSONArray reclamations = (JSONArray) jsonParser.parse(soinTest);
        long[] attendu = {0, 100, 150, 175, 300, 400, 500, 600, 700};
        long[] obtenu = TableauxMontants.obtenirSoin(reclamations);
        assertArrayEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("Lance l'exception ParseException attendue si le fichier json est incorrecte")
    void testParseExceptionObtenirSoin() throws ParseException {
        String soinTest = "[{\"soin\": \"200\"}]";
        JSONParser jsonParser = new JSONParser();
        JSONArray reclamations = null;
        try {
            reclamations = (JSONArray) jsonParser.parse(soinTest);
        } catch (ParseException e) {
            //final pour expression lambda dans assertThrows
            JSONArray finalReclamations = reclamations;
            assertThrows(ParseException.class, () -> TableauxMontants.obtenirSoin(finalReclamations));
        }
    }

    @Test
    @DisplayName("S'assure que les dates sont mises correctement dans le tableau")
    void testTabDate() throws ParseException, IOException {
        String montantsTest = "[{\"date\": \"2023-03-19\"}, {\"date\": \"2002-03-20\"}]";
        JSONParser jsonParser = new JSONParser();
        JSONArray reclamations = (JSONArray) jsonParser.parse(montantsTest);
        String[] attendu = {"2023-03-19", "2002-03-20"};
        String[] obtenu = TableauxMontants.tabDate(reclamations);
        assertArrayEquals(attendu, obtenu);
    }

    @Test
    @DisplayName("S'assure qu'une ParseException est lancée quand le fichier JSON est incorrect")
    void testParseTabDate() throws ParseException, IOException {
        //json incorrect
        String datesTest = "[{\"date\": 200}]";
        JSONParser jsonParser = new JSONParser();
        JSONArray reclamations = null;
        try {
            reclamations = (JSONArray) jsonParser.parse(datesTest);
        } catch (ParseException e) {
            //final pour expression lambda dans assertThrows
            JSONArray finalReclamations = reclamations;
            assertThrows(ParseException.class, () -> TableauxMontants.tabDate(finalReclamations));
        }
    }

    @Test
    @DisplayName("Traduit correctement les valeurs de type double en String sous forme de tableau")
    void testRemboursements() {
        double[] t1 = {0.000001, 0.01, 0, 1, 10000000, 999999999};
        String[] t2 = TableauxMontants.remboursements(t1);
        assertEquals("0.00", t2[0]);
        assertEquals("0.00", t2[1]);
        assertEquals("0.01", t2[3]);
        assertEquals("100000.00", t2[4]);
        assertEquals("9999999.99", t2[5]);
    }
}
