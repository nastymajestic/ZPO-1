
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        double tStart = System.nanoTime();
        isPrimeCalculate isPrimeCalculate = (new isPrimeCalculate(1, 9999));
        double tKoncowe = (System.nanoTime() - tStart) / 1000000000;
        System.out.println("czas wykonania RecursiveTaska:");
        System.out.println(tKoncowe);
        LinkedList<Integer> liczbyPierwsze = ForkJoinPool.commonPool().invoke(isPrimeCalculate);
        System.out.println("5 najwiekszych liczb bliniaczych w zbiorze:");
        Collections.sort(liczbyPierwsze, Collections.reverseOrder());
        Integer ostatnia = liczbyPierwsze.poll();

        int count = 0;
        for (Integer pierwsza : liczbyPierwsze) {
            if (ostatnia - pierwsza == 2) {
                System.out.println(pierwsza + " " + ostatnia);
                count++;
                if (count == 5) {
                    break;
                }
            }
            ostatnia = pierwsza;
        }


    }

    static class isPrimeCalculate extends RecursiveTask<LinkedList<Integer>> {
        static final int SEQUENTIAL_THRESHOLD = 100;

        int przedzialPoczatek;
        int przedzialKoniec;

        isPrimeCalculate(int begin, int end) {
            this.przedzialPoczatek = begin;
            this.przedzialKoniec = end;
        }

        protected LinkedList<Integer> compute() {

            if (przedzialKoniec - przedzialPoczatek <= SEQUENTIAL_THRESHOLD) {
                return getPrimes(przedzialPoczatek, przedzialKoniec);
            } else {
                int mid = przedzialPoczatek + (przedzialKoniec - przedzialPoczatek) / 2;
                isPrimeCalculate left = new isPrimeCalculate(przedzialPoczatek, mid);
                isPrimeCalculate right = new isPrimeCalculate(mid + 1, przedzialKoniec);
                left.fork();
                LinkedList<Integer> rightAns = right.compute();
                LinkedList<Integer> leftAns = left.join();
                LinkedList<Integer> summaryArray = new LinkedList<>();
                summaryArray.addAll(leftAns);
                summaryArray.addAll(rightAns);
                return summaryArray;
            }
        }


        public LinkedList<Integer> getPrimes(int start, int end) {
            LinkedList<Integer> primes = new LinkedList<Integer>();

            for (int i = start; i <= end; ++i) {
                if (isPrime(i)) {
                    primes.add(i);
                }
            }
            return primes;
        }

        private boolean isPrime(int liczba) {
            if (liczba == 1) {
                return false;
            }
            if (liczba == 2 || liczba == 3) {
                return true;
            }
            if (liczba > 3) {
                if (liczba % 2 == 0) {
                    return false;
                }
                for (int i = 3; i <= Math.sqrt(liczba); i++) {
                    if (liczba % i == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
