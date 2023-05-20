import net.sf.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.time.format.DateTimeParseException;


public class Main {

    public static String FICHIER;
    public static String FICHIER_OUTPUT;

    public static int i = 0;

    public static void main(String[] args) throws IOException, ParseException {
        double remboursement = 0;

        if (args.length < 2) {
            System.out.println("Invalid arguments");
            System.exit(1);
        }


        try {
            FICHIER = args[0];
            FICHIER_OUTPUT = args[1];

            JsonInputOutput json = new JsonInputOutput(FICHIER, FICHIER_OUTPUT);
            ValidateurJson.validerJson(Validations.obtenirJsonObject(Main.FICHIER));
            json.load();
            JSONArray reclamations = JsonInputOutput.JSONArray();

            if (args.length == 3 && args[2].equals("-S")) {
                Statistiques statistiques = new Statistiques("stats.txt");
                statistiques.load();
                // Mettre à jour les staqtistiques (ex. à chaque traitement de réclamation)
                statistiques.updateStats(FICHIER);
                statistiques.setStats(statistiques.getStats());
                statistiques.setStatsRefus(statistiques.getStatsRefus());
                statistiques.save();
                statistiques.printToConsole();
            }else if (args.length == 3 && args[2].equals("-SR")){
                Statistiques statistiques = new Statistiques("stats.txt");
                statistiques.resetStats();
                statistiques.save();
                System.out.println("Les statistiques ont été réinitialisées\n");
            }



                Validations.validerMois(Main.FICHIER);


            try {

                ReclamationDate.ValideReclamationDate();
                NumeroSoin.validerNum(FICHIER);
                String contrat = Validations.recupererTypeContrat(FICHIER);
                Validations.validerTypeContrat(contrat);
                Validations.verifierSigneDollar(FICHIER);
                Validations.verifierNoDossier(FICHIER);
                int[] tabMontant = TableauxMontants.obtenirMontant(reclamations);
                long[] soins = TableauxMontants.obtenirSoin(reclamations);
                Validations.validSoin(soins);
                double[] rembours = Remboursements.tabRembours(contrat, soins, tabMontant, remboursement, FICHIER);
                String[] dates = TableauxMontants.tabDate(reclamations);
                String[] remboursements = TableauxMontants.remboursements(rembours);


                if (i == 1) {
                    MessageErreur.afficherMessageErreur("Le champ Validations.Mois n'est pas dans le bon format", Main.FICHIER_OUTPUT);
                } else if (i == 2) {
                    MessageErreur.afficherMessageErreur("Le signe dollar est invalide", Main.FICHIER_OUTPUT);
                } else if (i == 3) {
                    MessageErreur.afficherMessageErreur("Le numéro de dossier est invalide", Main.FICHIER_OUTPUT);
                } else if (i == 4) {
                    MessageErreur.afficherMessageErreur("Le type de soin est invalide", Main.FICHIER_OUTPUT);
                } else if (i == 5) {
                    MessageErreur.afficherMessageErreur("La date est invalide", Main.FICHIER_OUTPUT);

                } else {
                    JsonInputOutput.to_string(remboursements, soins, dates);
                }


            } catch (java.text.ParseException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException | NoSuchFileException e) {
            System.out.println("Fichier non trouvé");
        } catch (JSONException e) {
            MessageErreur.afficherMessageErreur("Les propriétés 'reclamations, mois ou dossier' sont manquantes dans le fichier JSON", Main.FICHIER_OUTPUT);
        }
    }


}
