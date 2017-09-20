package string.search;

import java.util.Collection;
import java.util.Iterator;

public class Consumer implements Runnable {
    private Collection<Product> store;
    private String stringToSearch;

    public Consumer(Collection<Product> store, String stringToSearch) {
        this.store = store;
        this.stringToSearch = stringToSearch;
    }

    public void run() {
        boolean interrupted = false;

        while (!store.isEmpty()) {
            synchronized (store) {
                Iterator<Product> iter = store.iterator();

                while (iter.hasNext()) {
                    Product product = iter.next();
                    if (product.getLine().contains(stringToSearch)) {
                        try {
                            product.printProduct();
                        } catch (InterruptedException e) {
                            interrupted = true;
                        }
                        iter.remove();
                    }
                }
//
//                if (interrupted) {
//                    return;
//                }

                try {
                    store.wait();
                } catch (InterruptedException e) {
                    return;                }
            }
        }
    }
}
