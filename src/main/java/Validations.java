import net.sf.json.JSONSerializer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Validations {
    //public static boolean VALIDER = false;
    private static boolean estSoinValide;


    public static void verifierSigneDollar(String fichier) {
        JSONParser jsonParser = new JSONParser();
        try {
            Object obj = jsonParser.parse(new FileReader(fichier));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray reclamations = (JSONArray) jsonObject.get("reclamations");
            for (Object reclamation : reclamations) {
                JSONObject reclamationsObject = (JSONObject) reclamation;
                String montant = (String) reclamationsObject.get("montant");
                if (!montant.endsWith("$")) {

                    Main.i = 2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessageErreur.afficherMessageErreur("Le signe dollar est invalide", Main.FICHIER_OUTPUT);
        }
    }


    public static void validerTypeContrat(String dossier) {
        if (dossier.contains("A") || dossier.contains("B") || dossier.contains("C") || dossier.contains("D") || dossier.contains("E")) {
        } else { // msg d'erreur
            Main.i = 3;

        }
    }


    public static void verifierNoDossier(String fichier) {

        JSONParser jsonParser2 = new JSONParser();
        try {
            Object obj = jsonParser2.parse(new FileReader(fichier));
            JSONObject jsonObject = (JSONObject) obj;
            String dossier = (String) jsonObject.get("dossier");
            Pattern clientPattern = Pattern.compile("^[A-E][0-9]{6}$");

            if (clientPattern.matcher(dossier).matches()) {

            } else { // le numéro de dossier est invalide donc msg erreur
                Main.i = 3;
            }
        } catch (Exception e) {
        }
    }


    /**
     * Imprime un message si un type de soin est invalide
     *
     * @param soins
     * @throws IOException
     * @throws ParseException
     */
    public static void validSoin(long[] soins) throws IOException, ParseException {
        for (int i = 0; i < soins.length; i++) {
            long soin = soins[i];
            if (!verifierSoinValide(soin, estSoinValide)) {
                Main.i = 4;
                break;
            }
        }
    }

    /**
     * Vérifie si un type de soin est invalide
     *
     * @param soin
     * @param estSoinValide
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static boolean verifierSoinValide(long soin, boolean estSoinValide) throws IOException, ParseException {
        if (soin == 0 || soin == 100 || soin == 150 || soin == 175 || soin == 200 || soin == 500 || soin == 600 || soin == 700) {
            estSoinValide = true;
        } else if (soin >= 300 & soin <= 400) {
            estSoinValide = true;
        }
        return estSoinValide;
    }


    public static String recupererTypeContrat(String fichier) throws IOException, ParseException {
        FileReader reader = new FileReader(fichier);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

        String contrat = (String) jsonObject.get("dossier");
        if (contrat.contains("A")) {
            contrat = "A";
        } else if (contrat.contains("B")) {
            contrat = "B";
        } else if (contrat.contains("C")) {
            contrat = "C";
        } else if (contrat.contains("D")) {
            contrat = "D";
        } else if (contrat.contains("E")) {
            contrat = "E";
        }


        return contrat;
    }


    /**
     * Méthode qui récupère le document JSON et qui vérifie que le mois des réclamations est valide.
     */
    public static void validerMois(String fichier) {

        try {
            net.sf.json.JSONObject jsonObject = obtenirJsonObject(fichier);
            String month = jsonObject.getString("mois");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
            dateFormat.setLenient(false);
            try {
                Date date = dateFormat.parse(month); // vérification que le champ "mois" est au format attendu
                if (month != null && !month.isEmpty()) {
                    if (!month.matches("\\d{4}-\\d{2}")) { // verifie que le mois est dans le format YYYY-MM
                        System.out.println("Veuillez entrer un mois valide");
                    }

                }            } catch (java.text.ParseException e) {
                Main.i = 1;
                //VALIDER = true;
            }
        } catch (IOException e) {
            System.out.println("Fichier non trouvé");
        }
    }

    public static net.sf.json.JSONObject obtenirJsonObject(String fichier) throws IOException {
        String stringFile = FileHash.readFileToString(fichier);
        net.sf.json.JSONObject jsonObject = (net.sf.json.JSONObject) JSONSerializer.toJSON(stringFile); // récupération du document JSON
        return jsonObject;
    }


}
