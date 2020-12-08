package threadwords;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Valle
 */
public class ThreadWords {

    private static final int THREAD_NUM = 6;

    public static void main(String[] args) throws IOException {
        
        // Zero Thread
        Word word = new Word();
        word.findWord("so-called", "src/dataset/", 3);

        /**
         * Many Threads
         * @params word, path, files
         */
        FindWord fd = new FindWord("so-called", "src/dataset/", 186);

        try {
            ArrayList<Thread> threads = new ArrayList<>(THREAD_NUM);
            for (int i = 0; i < THREAD_NUM; i++) {
                Thread thread = new Thread(fd);
                thread.start();
                threads.add(thread);
            }

            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
