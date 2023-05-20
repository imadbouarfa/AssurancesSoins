import net.sf.json.JSONArray;
import java.io.IOException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;


public class ReclamationDate {
    /**
     *Méthode qui récupère le document JSON, ainsi que le mois et les dates de réclamations de ce dernier.
     */
    public static void ValideReclamationDate() {
        try {
            obtenirJsonObject(Main.FICHIER);
            obtenirDate();
            validerDateReclamation(Main.FICHIER);
        } catch (IOException e) {
            MessageErreur.afficherMessageErreur("La date est invalide", Main.FICHIER_OUTPUT);
        }
    }


    public static void obtenirDate() {
        try {
            JSONArray reclamations = obtenirJsonObject(Main.FICHIER).getJSONArray("reclamations");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            obtenirDateTableau(reclamations, format);
        } catch (IOException e) {
            MessageErreur.afficherMessageErreur("La date est invalide", Main.FICHIER_OUTPUT);
        }
    }

    public static void obtenirDateTableau(JSONArray reclamations, SimpleDateFormat format) {
        for (int i = 0; i < reclamations.size(); i++) {
            JSONObject reclamation = reclamations.getJSONObject(i);
            String date = reclamation.getString("date");
            try {
                Date dateObject = format.parse(date);
                validerFormat(date);
            } catch (ParseException e) {
                MessageErreur.afficherMessageErreur("La date est invalide", Main.FICHIER_OUTPUT);
            }
        }
    }

    public static JSONObject obtenirJsonObject(String fichier) throws IOException {
        String stringFile = FileHash.readFileToString(fichier);
        JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(stringFile); // récupération du document JSON
        return jsonObject;
    }

    public static void validerFormat(String date) {
        if (date != null && !date.isEmpty()) {
            if(! date.matches("\\d{4}-\\d{2}-\\d{2}")){ // verifie que la date est dans le format YYYY-MM
                System.out.println("Veuillez rentrer un mois valide");
            }
        }
    }

    public static void validerDateReclamation(String fichier) {
        try {
            JSONArray reclamations = obtenirJsonObject(fichier).getJSONArray("reclamations");
            // mois en cours de traitement
            String mois = obtenirJsonObject(fichier).getString("mois");
            for(int i=0;i<reclamations.size();i++) {
                JSONObject reclamation = reclamations.getJSONObject(i);
                String date = reclamation.getString("date");
                //comparer avec le mois en cours de traitement
                if(!date.substring(5,7).equals(mois.substring(5,7))) {
                    Main.i = 5;
                }
                isValidDay(date);
            }
        } catch (IOException e) {
            System.out.println("Fichier non trouvé");
        }
    }

    public static boolean isValidDay(String dateStr) {
        try {
            LocalDate date = LocalDate.parse(dateStr);
            YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
            int maxDaysInMonth = yearMonth.lengthOfMonth();
            int dayOfMonth = date.getDayOfMonth();
            return dayOfMonth >= 1 && dayOfMonth <= maxDaysInMonth;
        } catch (Exception e) {
            Main.i = 5;
        }
        return false;
    }


}



