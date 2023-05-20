import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Remboursements extends Main {

    public Remboursements() throws IOException, ParseException {
    }

    /**
     * methode qui construit un tableau comprenant les montants des remboursements
     * @param contrat
     * @param soins
     * @param tabMontant
     * @param remboursement
     * @return tabRembours[]
     * @throws IOException
     * @throws ParseException
     */
    public static double[] tabRembours(String contrat, long[] soins, int[]tabMontant, double remboursement, String fichier) throws IOException, ParseException, java.text.ParseException {
        double[] tabRembours = new double[soins.length];
        for (int i = 0; i < soins.length; i++) {
            long soin = soins[i];
            int unMontant = tabMontant[i];
            switch (contrat) {
                case "A":
                    remboursement = Contrats.contratA(soin, unMontant, fichier);
                    break;
                case "B":
                    remboursement = Contrats.contratB(soin, unMontant, fichier);
                    break;    
                case "C":
                    remboursement = Contrats.contratC(soin, unMontant, fichier);
                    break;
                case "D":
                    remboursement = Contrats.contratD(soin, unMontant, fichier);
                    break;
                case "E":
                    remboursement = Contrats.contratE(soin, unMontant, fichier);
                    break;
            }
            tabRembours[i] = remboursement;
        }
        return tabRembours;
    }
}
