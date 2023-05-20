import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.io.IOException;

public class NumeroSoin {

    /**
     * Méthode qui vérifie que le numéro de soin entré est valide.
     */
    public static void validerNum(String fichier) throws IOException {
            JSONArray reclamations = Validations.obtenirJsonObject(fichier).getJSONArray("reclamations");
            for (int i = 0; i < reclamations.size(); i++) {
                JSONObject reclamation = reclamations.getJSONObject(i);
                int soin = reclamation.getInt("soin");
                if (soin != 0 && soin != 100 && soin != 150 && soin != 175 && soin != 200 && soin != 400 && soin != 500 && soin != 600 && soin != 700) {
                    if (soin < 300 || soin > 399) {
                        Main.i = 4;
                    }
                }
            }
    }
}
