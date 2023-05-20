import java.io.IOException;
import java.text.ParseException;

/**
 * Effectue les calculs pour les contrats B et D et E
 */

public class Contrats {
    public static double remboursement = 0;
    public static double rabaisMax = 0; // À multiplier par 100 pour supporter les décimales
    public static String msgErr = "Le montant doit être positif";

    public static double maxMonth100 = 0;
    public static double maxMonth175 = 0;
    public static double maxMonth200 = 0;
    public static double maxMonth500 = 0;
    public static double maxMonth600 = 0;

    public static double calculRabais50(double unMontant, double rabaisMax){
        if (unMontant < 0 || rabaisMax < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.50;
        if (remboursement > rabaisMax && rabaisMax != 0) {
            remboursement = rabaisMax;
        }
        return (remboursement);
    }
    public static double calculRabais100(double unMontant, double rabaisMax){
        if (unMontant < 0 || rabaisMax < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant;
        if (remboursement > rabaisMax && rabaisMax != 0) {
            remboursement = rabaisMax;
        }
        return (remboursement);
    }
    public static double calculRabais70(double unMontant){
        if (unMontant < 0) {
            throw new IllegalArgumentException(msgErr);
        }

        remboursement = unMontant * 0.70;
        return (remboursement);
    }
    public static double calculRabais75(double unMontant){
        if (unMontant < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.75;
        return (remboursement);
    }
    public static double calculRabais95(double unMontant){
        if (unMontant < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.95;
        return (remboursement);
    }
    public static double calculRabais15(double unMontant){
        if (unMontant < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.15;
        return (remboursement);
    }
    public static double calculRabais25(double unMontant, double rabaisMax){
        if (unMontant < 0 || rabaisMax < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.25;
        if (remboursement > rabaisMax && rabaisMax != 0) {
            remboursement = rabaisMax;
        }
        return (remboursement);
    }
    public static double calculRabais12(double unMontant){
        if (unMontant < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.12;
        return (remboursement);
    }
    public static double calculRabais60(double unMontant){
        if (unMontant < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.60;
        return (remboursement);
    }
    public static double calculRabais35(double unMontant){
        if (unMontant < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.35;
        return (remboursement);
    }
    public static double calculRabais40(double unMontant){
        if (unMontant < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.40;
        return (remboursement);
    }
    public static double calculRabais90(double unMontant){
        if (unMontant < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.90;
        return (remboursement);
    }
    public static double calculRabais30(double unMontant, double rabaisMax){
        if (unMontant < 0 || rabaisMax < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.30;
        if (remboursement > rabaisMax && rabaisMax != 0) {
            remboursement = rabaisMax;
        }
        return (remboursement);
    }
    public static double calculRabais22(double unMontant) {
        if (unMontant < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.22;
        return (remboursement);
    }
    public static double calculRabais85(double unMontant) {
        if (unMontant < 0) {
            throw new IllegalArgumentException(msgErr);
        }
        remboursement = unMontant * 0.85;
        return (remboursement);
    }

    public static double contratA (long soin, double unMontant, String fichier) throws IOException, ParseException, org.json.simple.parser.ParseException {
        soin0(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin100(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin150(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin175(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin200(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin300(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin400(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin500(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin600(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin700(soin, unMontant, Validations.recupererTypeContrat(fichier));

        return (remboursement);
    }
    public static double contratB (long soin, double unMontant, String fichier) throws IOException, ParseException, org.json.simple.parser.ParseException {
        soin0(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin100(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin150(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin175(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin200(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin300(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin400(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin500(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin600(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin700(soin, unMontant, Validations.recupererTypeContrat(fichier));
        return (remboursement);
    }
    public static double contratC (long soin, double unMontant, String fichier) throws IOException, ParseException, org.json.simple.parser.ParseException {
        soin0(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin100(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin150(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin175(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin200(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin300(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin400(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin500(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin600(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin700(soin, unMontant, Validations.recupererTypeContrat(fichier));
        return (remboursement);
    }
    public static double contratD (long soin, double unMontant, String fichier) throws IOException, ParseException, org.json.simple.parser.ParseException {
        soin0(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin100(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin150(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin175(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin200(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin300(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin400(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin500(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin600(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin700(soin, unMontant, Validations.recupererTypeContrat(fichier));
        return (remboursement);
    }public static double contratE (long soin, double unMontant, String fichier) throws IOException, ParseException, org.json.simple.parser.ParseException {
        soin0(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin100(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin150(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin175(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin200(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin300(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin400(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin500(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin600(soin, unMontant, Validations.recupererTypeContrat(fichier));
        soin700(soin, unMontant, Validations.recupererTypeContrat(fichier));
        return (remboursement);
    }
    public static void soin0 (long soin, double unMontant, String contrat){
        if(soin == 0) {
            if (contrat.contains("A")) {
                rabaisMax = 0;
                remboursement = calculRabais25(unMontant, rabaisMax);
            }
            if (contrat.contains("B")) {
                rabaisMax = 40 * 100;
                remboursement = calculRabais50(unMontant, rabaisMax);
            }
            if (contrat.contains("C")) {
                remboursement = calculRabais90(unMontant);
            }
            if (contrat.contains("D")) {
                rabaisMax = 85 * 100;
                remboursement = calculRabais100(unMontant, rabaisMax);
            }
            if (contrat.contains("E")) {
                remboursement = calculRabais15(unMontant);
            }
        }
    }
    public static void soin100 (long soin, double unMontant, String contrat){
        if(soin == 100) {
            if (contrat.contains("A")) {
                remboursement = calculRabais35(unMontant);
            }
            if (contrat.contains("B")) {
                rabaisMax = 50 * 100;
                remboursement = calculRabais50(unMontant, rabaisMax);
            }
            if (contrat.contains("C")) {
                remboursement = calculRabais95(unMontant);
            }
            if (contrat.contains("D")) {
                rabaisMax = 75 * 100;
                remboursement = calculRabais100(unMontant, rabaisMax);
            }
            if (contrat.contains("E")) {
                rabaisMax = 0;
                remboursement = calculRabais25(unMontant, rabaisMax);
            }
            if (maxMonth100 + remboursement > (250 * 100)) {
                remboursement = (250 * 100) - maxMonth100;
            }
            maxMonth100 += remboursement;
        }
    }
    public static void soin150 (long soin, double unMontant, String contrat){
        if(soin == 150) {
            if (contrat.contains("A")) {
                remboursement = 0;
            }
            if (contrat.contains("B")) {
                remboursement = 0;
            }
            if (contrat.contains("C")) {
                remboursement = calculRabais85(unMontant);
            }
            if (contrat.contains("D")) {
                rabaisMax = 150 * 100;
                remboursement = calculRabais100(unMontant, rabaisMax);
            }
            if (contrat.contains("E")) {
                remboursement = calculRabais15(unMontant);
            }
        }
    }
    public static void soin175 (long soin, double unMontant, String contrat){
        if(soin == 175) {
            if (contrat.contains("A")) {
                rabaisMax = 0;
                remboursement = calculRabais50(unMontant, rabaisMax);
            }
            if (contrat.contains("B")) {
                remboursement = calculRabais75(unMontant);
            }
            if (contrat.contains("C")) {
                remboursement = calculRabais90(unMontant);
            }
            if (contrat.contains("D")) {
                remboursement = calculRabais95(unMontant);
            }
            if (contrat.contains("E")) {
                rabaisMax = 20 * 100;
                remboursement = calculRabais25(unMontant, rabaisMax);
            }
            if (maxMonth175 + remboursement > (200 * 100)) {
                remboursement = (200 * 100) - maxMonth175;
            }
            maxMonth175 += remboursement;
        }


    }
    public static void soin200 (long soin, double unMontant, String contrat){
        if(soin == 200) {
            if (contrat.contains("A")) {
                rabaisMax = 0;
                remboursement = calculRabais25(unMontant, rabaisMax);
            }
            if (contrat.contains("B")) {
                rabaisMax = 0;
                remboursement = calculRabais100(unMontant, rabaisMax);
            }
            if (contrat.contains("C")) {
                remboursement = calculRabais90(unMontant);
            }
            if (contrat.contains("D")) {
                rabaisMax = 100 * 100;
                remboursement = calculRabais100(unMontant, rabaisMax);
            }
            if (contrat.contains("E")) {
                remboursement = calculRabais12(unMontant);
            }
            if (maxMonth200 + remboursement > (250 * 100)) {
                remboursement = (250 * 100) - maxMonth200;
            }
            maxMonth200 += remboursement;
        }
    }
    public static void soin300 (long soin, double unMontant, String contrat){
        if (soin >= 300 && soin <= 399) {
            if (contrat.contains("A")) {
                remboursement = 0;
            }
            if (contrat.contains("B")){
                rabaisMax = 0;
                remboursement = calculRabais50(unMontant, rabaisMax);
            }
            if (contrat.contains("C")) {
                remboursement = calculRabais90(unMontant);
            }
            if (contrat.contains("D")){
                rabaisMax = 0;
                remboursement = calculRabais100(unMontant, rabaisMax);
            }
            if (contrat.contains("E")) {
                remboursement = calculRabais60(unMontant);
            }
        }
    }
    public static void soin400 (long soin, double unMontant, String contrat){
        if(soin == 400) {
            if (contrat.contains("A")) {
                remboursement = 0;
            }
            if (contrat.contains("B")) {
                remboursement = 0;
            }
            if (contrat.contains("C")) {
                remboursement = calculRabais90(unMontant);
            }
            if (contrat.contains("D")) {
                rabaisMax = 65 * 100;
                remboursement = calculRabais100(unMontant, rabaisMax);
            }
            if (contrat.contains("E")) {
                rabaisMax = 15 * 100;
                remboursement = calculRabais25(unMontant, rabaisMax);
            }
        }
    }
    public static void soin500 (long soin, double unMontant, String contrat){
        if(soin == 500) {
            if (contrat.contains("A")) {
                rabaisMax = 0;
                remboursement = calculRabais25(unMontant, rabaisMax);
            }
            if (contrat.contains("B")) {
                rabaisMax = 50 * 100;
                remboursement = calculRabais50(unMontant, rabaisMax);
            }
            if (contrat.contains("C")) {
                remboursement = calculRabais90(unMontant);
            }
            if (contrat.contains("D")) {
                rabaisMax = 0;
                remboursement = calculRabais100(unMontant, rabaisMax);
            }
            if (contrat.contains("E")) {
                rabaisMax = 20 * 100;
                remboursement = calculRabais30(unMontant, rabaisMax);
            }
            if (maxMonth500 + remboursement > (150 * 100)) {
                remboursement = (150 * 100) - maxMonth500;
            }
            maxMonth500 += remboursement;
        }
    }
    public static void soin600 (long soin, double unMontant, String contrat){
        if (soin == 600) {
            if (contrat.contains("A")) {
                remboursement = calculRabais40(unMontant);
            }
            if (contrat.contains("B")) {
                rabaisMax = 0;
                remboursement = calculRabais100(unMontant, rabaisMax);
            }
            if (contrat.contains("C")) {
                remboursement = calculRabais75(unMontant);
            }
            if (contrat.contains("D")) {
                rabaisMax = 100 * 100;
                remboursement = calculRabais100(unMontant, rabaisMax);
            }
            if (contrat.contains("E")) {
                remboursement = calculRabais15(unMontant);
            }
            if (maxMonth600 + remboursement > (300 * 100)) {
                remboursement = (300 * 100) - maxMonth600;
            }
            maxMonth600 += remboursement;
        }
    }
    public static void soin700 (long soin, double unMontant, String contrat){
        if (soin == 700) {
            if (contrat.contains("A")) {
                remboursement = 0;
            }
            if (contrat.contains("B")) {
                remboursement = calculRabais70(unMontant);
            }
            if (contrat.contains("C")) {
                remboursement = calculRabais90(unMontant);
            }
            if (contrat.contains("D")) {
                rabaisMax = 90 * 100;
                remboursement = calculRabais100(unMontant, rabaisMax);
            }
            if (contrat.contains("E")) {
                remboursement = calculRabais22(unMontant);
            }
        }
    }
}
