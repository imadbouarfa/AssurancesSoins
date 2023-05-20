# Description du project

Le projet est un logiciel qui calcul les remboursement de soins donnés à partir d'un fichier JSON et qui imprime un nouveau fichier avec les montants des remboursements.


## Authors

- [@Lounas, Nazim](https://gitlab.info.uqam.ca/lounas.nazim)
- [@Hameg, Idir](https://gitlab.info.uqam.ca/hameg.idir)
- [@Shaker, Imad](https://gitlab.info.uqam.ca/bouarfa.imad)
- [@Fortin, Xavier](https://gitlab.info.uqam.ca/fortin.xavier)


## Technologies
* IntelliJ IDEA (https://www.jetbrains.com/idea/)
* JSON lib (https://json-lib.sourceforge.net/)
* JSON simple (https://code.google.com/archive/p/json-simple/)
* Gson (https://github.com/google/gson)
* Jacoco (plugin de test) sprint 3


## Documentation

[Stackoverflow](https://stackoverflow.com/)


## Utilisation
* Ouvrir le projet sur IntelliJ
* Ouvrir le terminal 
* Entrer la commande 'java -jar <nom du fichier d'entrée> <choisir un nom pour le fichier de sortie> -S ou -SR' ou aller dans Edit Configurations de votre IDE et rentrer 'input output -SR' ou 'input output -S'


## Répartition des taches
#### Nazim (Scrum master)
Sprint 1:

Création d'une méthode/classe de validation du numéro client;

Création d'une méthode/classe de validation du type de contrat;

Création d'une méthode/classe de validation de la présence du signe dollar à la fin d'un montant;

Création d'une méthode/classe pour faire la génération du fichier de sortie lorsqu'il y a une donnée invalide;

Création d'une méthode/classe pour récuperer le type de contrat de la réclamation.

Sprint 2:

Création d'une méthode spécifique à chaque erreur possible et affiche le message d'erreur associé significatif avec des phrases complètes présentées directement à l'utilisateur

Remplacer la propriété client et contrat par dossier 

Création d'une classe test "ValidationsTest"pour la classe "Validations"

Création du workflow.md

Setup de Maven et des dependancies 

Sprint 3:


Création planDeTest.md

Intégration gitlab-ci 

Plugin de test

Création du Refund.jar

#### Imad
Sprint3: J'ai fait toutes les fonctionnalités requises pour la partie "Statistiques".

Sprint2: Ajout de la compatibilité des points et virgules dans les montants

Sprint2: Ajout du total des remboursements dans le fichier JSON.

Sprint2: Ajout des messages d'erreurs pour des propriétés manquantes et ajout des méthodes détectant les propriétés manquantes.

Sprint2: Création du fichier d'entré et sortie

Sprint2: Intégration test unitaires: ReclamationDateTest, JsonInputOutputTest et ValidateurJsonTest


Sprint1: J'ai créer la validation du fichier d'entrée et du fichier de sortie. 

Sprint1: Création de la classe "ValiderMois" qui contient des méthodes vérifiant que le mois des réclamations rentré est valide et dans le bon format. 

Sprint1: Création de la classe "ReclamationDate" qui contient des méthodes vérifiant que les dates des réclamations sont identiques au mois traité et qu'elles correspondent à une date valide sous le format approprié.

Sprint1: Création de la classe "NumeroSoin" qui contient des méthodes vérifiant que les numéros de soin rentrés sont valides selon le tableau mentionné.

Sprint1: J'ai également créer les classes "JsonInputOutput" et "FileHash" afin de pouvoir lire le fichier JSON et d'y créer un fichier de sortie.


#### Xavier
*Update Sprint 3*:
Création de nouveaux tests unitaires et refactoring de classes et méthodes pour faciliter l'implémentation de nouveaux tests: classes ContratsTest, MoisTest, JsonInputOutputTest, ReclamationDateTest, SoinTest, StatistiquesTest, TableauxMontantsTest, ValidateurJsonTest, ValidationsTest.

*Update Sprint 2*: 
Classe monnaie et son implémentation dans toutes les autres classes le nécessitant(Remboursements, JsonInputOutput, TableauxMontants, LongContratBDE...);
Modifications dans les classes Main, JsonInputOutput et TableauxMontants pour que les tableaux n'utilisent qu'un seul JsonParser;
Intégralité de la classe de tests unitaires TableauxMontantsTest;
Intégralité de la classe de tests unitaires RemboursementsTest;
Intégralité de la classe de tests unitaires MonnaieTest;
Update classe NumeroSoin: une seule méthode plutôt que deux
Correction du json de sortie qui n'imprimait que sur une seule ligne

*Sprint 1*: Méthode de vérification du numéro de soin (classe ValiderSoin) intégralement;
Méthodes allant parser le fichier inputfile.json pour en suite créer des tableaux des montants, des types de soins et des mois (classe Tableaux) intégralement;
Méthode pour calculer les remboursements puis en faire un tableau utilisable pour l'impression et méthodes pour le calcul des contrats B et C (classe Remboursements) intégralement;
Contribution à la classe JsonInputOuput pour finaliser l'impression dans le terminal et dans le fichier refunds.json;
Contribution au bon déroulement du l'ensemble du programme et de l'organisation de la méthode Main avec les autres membres de l'équipe;


#### Idir
*Sprint 1*:
Création d'une classe avec les calculs necessaires pour le fonctionnement du contrat B et D

Optimisation de certaines parties du code possiblement reductibles à 10 lignes par méthode

Correction de certains bugs

Création du fichier README.md

*Sprint 2*:
Ajout du type de contrat E

Ajout des deux nouveaux types de soin 150 et 175

Ajustement des nouvelles valeurs de rabais données

Utilisation de maven

Classe test pour les différents rabais et la classe contenant les contrats B, D et E

*Sprint 3*:
Correction de certaines erreur du sprint 2

Rassembler les différents contrats dans la même classe "Contrats"

Ajout du maximum monsuel pour les différents types de soin demandés


#### Bugs et optimisation
L'optimisation de certaines parties du code ainsi que la correction des différents bugs ont été effectués par l'ensemble de l'équipe lors des réunions.
