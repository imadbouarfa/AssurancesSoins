import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

    /**
    * Cette classe permet de lire un document JSON. J'ai recherché cette classe à partir du lien
    * suivant: https://gitlab.com/sergedelil/uqam/-/blob/master/INF2050/ateliers/IntelliJ/FileHash.java
    */
    public class FileHash {

        public static String readFileToString(String filename) throws IOException {

            return Files.readString(Paths.get(filename));
        }

    }


