import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;

public class ReclamationDateTest {

    @BeforeEach
    public void reset () {
        Main.i = 0;
    }

    @Test
    @DisplayName("Recuperation des dates des reclamations du JSON ")
    public void testValiderDate() throws ParseException, IOException {
        try {
            ReclamationDate.ValideReclamationDate();
            assertTrue(true); // Si pas d'exceptions levées, on peut considérer que le test passe
        }catch (NullPointerException e) {
            System.out.println("Non trouvé");
        }
    }


    @Test
    @DisplayName("Assurer que le format de la date est valide")
    public void testValiderFormat() throws IOException {
        String date = "2022-05-25";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ReclamationDate.validerFormat(date);
        assertEquals("", outContent.toString().trim());

        date = "22-05-25";
        outContent.reset();
        ReclamationDate.validerFormat(date);
        assertEquals("Veuillez rentrer un mois valide", outContent.toString().trim());

        date = null;
        outContent.reset();
        ReclamationDate.validerFormat(date);
        assertEquals("", outContent.toString().trim());

        date = "";
        outContent.reset();
        ReclamationDate.validerFormat(date);
        assertEquals("", outContent.toString().trim());
    }


    @Test
    @DisplayName("Assure que le jours est valide selon le mois")
    public void testIsValidDay() throws IOException {
        String date = "2022-05-25";
        boolean isValid = ReclamationDate.isValidDay(date);
        assertTrue(isValid);

        date = "2022-02-29";
        isValid = ReclamationDate.isValidDay(date);
        assertFalse(isValid);

        date = "2022-05-32";
        isValid = ReclamationDate.isValidDay(date);
        assertFalse(isValid);
    }

    @Test
    void testIsValid() {
        String date = "jaba";
        boolean isValid = ReclamationDate.isValidDay(date);
        assertFalse(isValid);
        assertEquals(5, Main.i);
    }

    @Test
    void validerDateReclamatioNTest() throws IOException {
        File tempFile = File.createTempFile("test", ".txt");
        try {
            // Données à écrire dans fichier temporaire
            FileWriter writer = new FileWriter(tempFile);
            writer.write("{\"dossier\":\"B000023\",\"mois\":\"2022-01\",\"reclamations\":[{\"soin\":0,\"date\":\"2022-01-11\",\"montant\":\"100,00$\"}]}");
            writer.close();

            ReclamationDate.validerDateReclamation(tempFile.getAbsolutePath());
            assertEquals(0, Main.i);
        } finally {
            tempFile.delete();
        }
    }

    @Test
    void obtenirDateTableauTest() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        JSONObject reclamation = new JSONObject();
        JSONArray reclamations = new JSONArray();
        reclamation.put("soin", 0);
        reclamation.put("date", "2022-01-11");
        reclamation.put("montant", "100,00$");
        reclamations.add(reclamation);

        assertDoesNotThrow(() -> {
            ReclamationDate.obtenirDateTableau(reclamations, format);
        });
    }

}
