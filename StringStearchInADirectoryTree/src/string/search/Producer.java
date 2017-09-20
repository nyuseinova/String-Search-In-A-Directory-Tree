package string.search;

import java.io.*;
import java.util.Collection;

public class Producer implements Runnable {
    private Collection<Product> store;
    private File file;

    public Producer(Collection<Product> store, File file) {
        this.store = store;
        this.file = file;
    }

    public void run() {
        synchronized (store) {
            try (LineNumberReader lnr = new LineNumberReader((new FileReader(file)))) {
                String line = lnr.readLine();
                while (line != null) {
                    String fileName = file.getName();
                    int lineNumber = lnr.getLineNumber();
                    Product newProduct = new Product(fileName, lineNumber, line);
                    store.add(newProduct);
                    store.notify();
                    line = lnr.readLine();
                }
            } catch (FileNotFoundException fnf) {
                System.out.println("File not found.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

