import net.sf.json.JSONException;
import net.sf.json.JSONObject;


import java.io.IOException;

public class ValidateurJson {

    /**
     * Methode qui verifie s'il y a une propriete manquante
     * @param fichier
     * @throws IOException
     */
    public static void validerJson(JSONObject fichier) throws IOException {
        try {
            if (!fichier.has("dossier")) {
                MessageErreur.afficherMessageErreur("La propriété 'dossier' est manquante dans le fichier JSON", Main.FICHIER_OUTPUT);
            }
            if (!fichier.has("mois")) {
                MessageErreur.afficherMessageErreur("La propriété 'mois' est manquante dans le fichier JSON", Main.FICHIER_OUTPUT);
            }
            if (!fichier.has("reclamations")) {
                MessageErreur.afficherMessageErreur("La propriété 'reclamations' est manquante dans le fichier JSON", Main.FICHIER_OUTPUT);
            }
        } catch (JSONException e) {

        }
    }
}
