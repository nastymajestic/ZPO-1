import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class isPrime extends RecursiveTask<Long> {
    static final int SEQUENTIAL_THRESHOLD = 15;

    int low;
    int high;
    int[] array;

    isPrime(int[] arr, int lo, int hi) {
        array = arr;
        low = lo;
        high = hi;
    }

    protected Long compute() {
        if (high - low <= SEQUENTIAL_THRESHOLD) {
            long sum = 0;
            for (int i = low; i < high; ++i)
                sum += array[i];
            return sum;
        } else {
            int mid = low + (high - low) / 2;
            isPrime left = new isPrime(array, low, mid);
            isPrime right = new isPrime(array, mid, high);
            left.fork();
            long rightAns = right.compute();
            long leftAns = left.join();
            return leftAns + rightAns;
        }
    }

    static long sumArray(int[] array) {
        return ForkJoinPool.commonPool().invoke(new isPrime(array, 0, array.length));
    }
}