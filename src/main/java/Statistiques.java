import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Statistiques {

    private String statsFile;
    private int stats; // Exemple de statistiques à accumuler
    private int statsRefus;
    private int statsType;
    private HashMap<Long, Integer> soinsCounts = new HashMap<>();
    private Map<Integer, Integer> soinsDeclares;



    public Statistiques(String statsFile) {
        this.statsFile = statsFile;
    }

    /**
     * Méthode pour sauvegarder les statistiques dans un fichier texte
     */
    public void save() {
        try {
            FileWriter writer = new FileWriter(statsFile);
            writer.write("Nombre de réclamations valides traitées : " + getStats());
            writer.write("\nNombre de réclamations rejetées : " + getStatsRefus());
            writer.write("\nNombre de soins déclarés pour chaque type de soin :\n" + verifierTypeSoin());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode pour mettre à jour les statistiques
     * @throws IOException
     * @throws ParseException
     */
    public void updateStats(String fichier) throws IOException, ParseException {
        FileReader reader = new FileReader(fichier);
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fichier));
        JSONObject jsonObject = (JSONObject) obj;
        org.json.simple.JSONArray reclamations = (JSONArray) jsonObject.get("reclamations");
        verifierReclamationsValides(reclamations);
    }

    /**
     * Méthode pour incrémenter le nombre de réclamations valides ou rejetées
     * @param reclamations
     * @throws IOException
     * @throws ParseException
     */
    public void verifierReclamationsValides(JSONArray reclamations) throws IOException, ParseException {
        long[] soins = TableauxMontants.obtenirSoin(reclamations);
        for(int i = 0; i < reclamations.size(); i++) {
            long soin = soins[i];
            if(soin == 0 || soin == 100 || soin == 150 || soin == 175 || soin == 200 || soin == 500 || soin == 600 || soin == 700) {
                incrementerTypeSoin(soin);
            } else if (soin >= 300 & soin <= 400) {
                incrementerTypeSoin(soin);
            } else {
                statsRefus++;
            }
        }
        verifierTypeSoin();
    }

    /**
     * Incrémente le compteur pour le type de soin
     * @param soin
     */
    private void incrementerTypeSoin(long soin) {
        int count = soinsCounts.getOrDefault(soin, 0);
        soinsCounts.put(soin, count + 1);
        stats++;
    }

    /**
     * Méthode pour calculer le nombre de soins déclarés pour chaque type de soin
     * @return
     */
    public String verifierTypeSoin() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Long, Integer> entry : soinsCounts.entrySet()) {
            long soin = entry.getKey();
            int count = entry.getValue();
            result.append("     Type de soin : ").append(soin).append(", Nombre de soins déclarés : ").append(count).append("\n");
        }
        return result.toString();
    }

    public void load() {
        try {
            FileReader reader = new FileReader(statsFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            modifieFichierTexte(bufferedReader);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void modifieFichierTexte(BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains("Nombre de réclamations valides traitées : ")) {
                stats = Integer.parseInt(line.split(": ")[1]);
            } else if (line.contains("Nombre de réclamations rejetées : ")) {
                statsRefus = Integer.parseInt(line.split(": ")[1]);
            } else if (line.contains("Type de soin : ")) {
                String[] parts = line.split(", Nombre de soins déclarés : ");
                long soin = Long.parseLong(parts[0].split(": ")[1].trim());
                int count = Integer.parseInt(parts[1].trim());
                soinsCounts.put(soin, count);
            }
        }
    }


    // Méthode pour récupérer les statistiques actuelles
    public int getStats() {
        // Récupérer les statistiques actuelles ici
        return stats;
    }
    public int getStatsRefus() {
        // Récupérer les statistiques actuelles ici
        return statsRefus;
    }

    // Réinitialiser les statistiques
    public void resetStats() {
        // Réinitialiser les statistiques ici
        stats = 0;
        statsRefus = 0;
        statsType = 0;
        soinsCounts.clear();
    }
    public int getStatsType() {
        // Récupérer les statistiques actuelles ici
        return statsType;
    }


    public void setStats(int stats) {
        this.stats = stats;
    }

    public void setStatsRefus(int statsRefus) {
        this.statsRefus = statsRefus;
    }


    public void printToConsole(){
        System.out.println("Nombre de réclamations valides traitées : " + getStats());
        System.out.println("\nNombre de réclamations rejetées : " + getStatsRefus());
        System.out.println("\nNombre de soins déclarés pour chaque type de soin :\n" + verifierTypeSoin());
        System.out.println("------------------------------------------------------------");
    }

}
