package threadwords;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author Rodrigo Valle
 */
public class Word {

    private int occurrence;
 
    public void findWord(String word, String path, int fileAmount) throws IOException {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        int cont = 0;
        for (File file : listOfFiles) {
            cont++;
            if (cont <= fileAmount && file.isFile() && file.getName().endsWith(".txt")) {
                List<String> list = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                list.forEach((line) -> {
                    if (line.toUpperCase().equals(word.toUpperCase())) {
                        occurrence++;
                    }
                });
            }
        }
    }

    public int printResultOccurrence() {
        return occurrence;
    }
}
