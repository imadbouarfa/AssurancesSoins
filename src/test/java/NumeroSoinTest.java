import net.sf.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumeroSoinTest {

    @Test
    public void testFichierNonExistent() {
        assertThrows(IOException.class, () -> {
            NumeroSoin.validerNum("");
        });
    }

    public String fauxFichier(String contenu) throws IOException {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);
        writer.write(contenu);
        writer.close();
        return stringWriter.toString();
    }

    @Test
    public void testValiderNum() throws IOException {
        File tempFile = File.createTempFile("test", ".txt");
        try {
            // Données à écrire dans fichier temporaire
            FileWriter writer = new FileWriter(tempFile);
            writer.write("{ \"reclamations\": [ { \"soin\": 2000 } ] }");
            writer.close();

            // Appeler la méthode et vérifier le résultat
            NumeroSoin.validerNum(tempFile.getAbsolutePath());
            assertEquals(4, Main.i);
        } finally {
            tempFile.delete();
        }
    }
}