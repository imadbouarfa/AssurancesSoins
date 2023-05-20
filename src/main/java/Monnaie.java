public class Monnaie {

    /**
     * Méthode qui convertit un montant double en cents et en int
     * @param montant le montant en double
     * @return montantConv le montant converti
     */
    public static int conversionInt(double montant) {
        int montantConv;
        montant = montant * 100;
        montantConv = (int) montant;
        return montantConv;
    }

    /**
     * Reconvertit un montant en int et en cents en montant avec les décimales, mais en String pour maintenir
     * la précision
     * @param montant le montant en int
     * @return montantExact le montant exact avec décimales sous forme de String
     */
    public static String reconversion(int montant) {
        String scents;
        int entier;
        int cents;
        String montantExact;
        entier = montant / 100;
        cents = montant % 100;
        if ((cents < 10) && (cents >= 1)){
            scents = "0" + cents;
            montantExact = entier + "." + scents;
        }
        else if(cents == 0) {
            //Afficher deux décimales en tout temps
            scents = "0" + "0";
            montantExact = entier + "." + scents;
        }
        else {
            montantExact = entier + "." + cents;
        }
        return montantExact;
    }
}
