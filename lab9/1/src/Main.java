import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;


public class Main {
    private static String[] strings = {"aaaa", "bb", "ccccccccccccc", "dddddd"};
    private static Queue<Integer> indexes = new LinkedBlockingQueue<>();


    public static void main(String[] args) throws InterruptedException {
        indexes.add(1);
        indexes.add(2);
        indexes.add(3);
        indexes.add(4);


        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                Integer wateknr = 1;
                String str = strings[0];

                for (int i = 0; i < str.length(); i++) {

                    while (indexes.peek() != wateknr) {
                    }

                    System.out.print(str.charAt(i));
                    indexes.poll();
                    if (i < (str.length() - 1)) {
                        synchronized (indexes) {
                            indexes.add(wateknr);
                        }
                    }
                }
            }


        });

        Thread b = new Thread(new Runnable() {
            String str = strings[1];

            @Override
            public void run() {
                Integer wateknr = 2;
                for (int i = 0; i < str.length(); i++) {
                    while (indexes.peek() != wateknr) {
                    }

                    System.out.print(str.charAt(i));
                    indexes.poll();
                    if (i < (str.length() - 1)) {
                        synchronized (indexes) {
                            indexes.add(wateknr);
                        }
                    }
                }
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                String str = strings[2];
                Integer wateknr = 3;
                for (int i = 0; i < str.length(); i++) {
                    while (indexes.peek() != wateknr) {
                    }

                    System.out.print(str.charAt(i));
                    indexes.poll();
                    if (i < (str.length() - 1)) {
                        synchronized (indexes) {
                            indexes.add(wateknr);
                        }
                    }
                }
            }
        });
        Thread d = new Thread(new Runnable() {
            @Override
            public void run() {
                String str = strings[3];
                Integer wateknr = 4;
                for (int i = 0; i < str.length(); i++) {

                    while (indexes.peek() != wateknr) {
                    }

                    System.out.print(str.charAt(i));
                    indexes.poll();
                    if (i < (str.length() - 1)) {
                        synchronized (indexes) {
                            indexes.add(wateknr);
                        }
                    }
                }

            }

        });

        ExecutorService es = Executors.newFixedThreadPool(4);
        es.submit(a);
        es.submit(b);
        es.submit(c);
        es.submit(d);
        es.shutdown();

    }


}

