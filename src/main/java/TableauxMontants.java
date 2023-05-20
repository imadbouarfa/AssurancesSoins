import com.google.gson.JsonArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TableauxMontants {

    /**
     * methode qui retourne un tableau comportant les montants en double (utilisé pour calculer les remboursements)
     * @return tabMontant
     * @throws IOException
     * @throws ParseException
     */
    public static int[] obtenirMontant(JSONArray reclamations) throws IOException, ParseException {
        int[] tabMontant = new int[reclamations.size()];
        for (int i = 0; i < reclamations.size(); i++) {
            JSONObject reclamationsObject = (JSONObject) reclamations.get(i);
            String montant = (String) reclamationsObject.get("montant");
            montant = montant.replace(',', '.'); // Remplace la virgule par un point (ajoute par imad)
            double montantd = Double.parseDouble(montant.substring(0, montant.length() - 1));
            int montanti = Monnaie.conversionInt(montantd);
            tabMontant[i] = montanti;
        }
        return tabMontant;
    }

    /**
     * methode qui retourne un tableau comportant les types de soin
     * @return typeSoin
     * @throws IOException
     * @throws ParseException
     */
    public static long[] obtenirSoin(JSONArray reclamations) throws IOException, ParseException {
        long[] typeSoin = new long[reclamations.size()];
        for (int i = 0; i < reclamations.size(); i++) {
            JSONObject reclamationsObject = (JSONObject) reclamations.get(i);
            long soin = (long) reclamationsObject.get("soin");
            typeSoin[i] = soin;
        }
        return typeSoin;
    }
    /**
     * methode qui retourne un tableau comportant les dates en String
     * @return tabDate
     * @throws IOException
     * @throws ParseException
     */
    public static String[] tabDate(JSONArray reclamations) throws IOException, ParseException {
        String[] tabDate = new String[reclamations.size()];
        for (int i = 0; i < reclamations.size(); i++) {
            JSONObject reclamationsObject = (JSONObject) reclamations.get(i);
            String date = (String) reclamationsObject.get("date");
            tabDate[i] = date;
        }
        return tabDate;
    }

    /**
     * Méthode qui construit un tableau des montants reconvertis en String après avoir passé par la
     * classe Monnaie
     * @param tabRembours le tableau de remboursements en Int et en cents
     * @return rembours le tableau des remboursements en String
     */
    public static String[] remboursements(double[] tabRembours) {
        String [] rembours = new String[tabRembours.length];
        int montant;
        String montantFinal;
        for (int i = 0; i < tabRembours.length; i++){
            montant = (int) tabRembours[i];
            montantFinal = Monnaie.reconversion(montant);
            rembours[i] = montantFinal;
        }
        return rembours;
    }
}
