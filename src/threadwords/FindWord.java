package threadwords;

import java.io.IOException;

/**
 *
 * @author Rodrigo Valle
 */
public class FindWord implements Runnable {

    private Word w;
    private String word;
    private String path;
    private int fileAmount;

    protected FindWord(String searchWord, String path, int fileAmount) {
        this.word = searchWord;
        this.path = path;
        this.fileAmount = fileAmount;
    }

    @Override
    public void run() {
        try {
            w = new Word();
            w.findWord(word, path, fileAmount);
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        } finally {
            System.out.println(w.printResultOccurrence());
        }
    }
}
