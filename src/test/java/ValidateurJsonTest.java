import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class ValidateurJsonTest {

    @Test
    @DisplayName("Verifie que le JSON est valide ")
    public void ValiderJsonTest() throws Exception {
        JSONObject fichierJson = new JSONObject();
        fichierJson.put("dossier", "A123");
        fichierJson.put("mois", "01");
        fichierJson.put("reclamations", "10");

        Assertions.assertDoesNotThrow(() -> ValidateurJson.validerJson(fichierJson));

    }

}
