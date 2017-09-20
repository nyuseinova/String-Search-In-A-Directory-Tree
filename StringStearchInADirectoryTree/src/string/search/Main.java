package string.search;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) throws IOException {
        Collection<Product> store = new ArrayList<Product>(); // linked list
        ArrayList<File> txtFiles = AllTxtFiles.findAllTxtFiles(Constants.dir);

        txtFiles.forEach(file -> {
            Thread producer = new Thread(new Producer(store, file));
            producer.start();
        });

        for(int i = 0; i < Constants.CONSUMERS; i++) {
            Thread consumer = new Thread(new Consumer(store, Constants.STRING_TO_SEARCH));
            //consumer.setDaemon(true);
            consumer.start();

            //consumer.interrupt();
        }
        // join all producers
        // interrupt all consumers
        // join all consumers
    }
}