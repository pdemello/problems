import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class epi8_3 {
    public static class Pair<T> {
        T a;
        T b;
        public Pair(T a, T b) {
            this.a = a;
            this.b = b;
        }
    }
	public static void main(String[] args) {
        long startTime = System.nanoTime();

        // First, generate a list of n random integers, sorted in ascending order
        // Let's say the values can range from -n to 2n.
        final int n = 100; // Length of array
        final double range = 1.6; // Range of random numbers.  3 means range of -n to 2n.
        final double underhang = .33333;
        int[] values = new int[n];
        for (int i = 0; i < n; ++i) {
            values[i] = (int)(n * (range * Math.random() - underhang) + .5);
        }
        Arrays.sort(values);
        for (int i = 0; i < values.length; ++i) {
            System.out.println(i + "\t" + values[i]);
        }

        // At this point, our array has decent input.
        // Now solve the problem.

        Queue<Pair<Integer>> q = new ArrayDeque<Pair<Integer>>();
        q.add(new Pair<Integer>(0, n-1));  // Let's use .a as bottom and .b as top
        int numIterations = 0;
        boolean found = false;
        while (!q.isEmpty() && numIterations < 30) {
            ++numIterations;
            Pair<Integer> p = q.remove();
            int i = (p.b - p.a) / 2;
            System.out.println("Checking index " + i);
            if (values[i] == i) {
                found = true;
                System.out.println("Found:  " + i);
                break;
            } else if (i > values[i]) {
                // TODO Need to change values[i] to values[i] < 0 ? 0 : values[i] ... or something
                if (p.a <= values[i] && values[i] <= values.length - 1)
                    q.add(new Pair<Integer>(p.a, values[i]));
                if (i+1 <= p.b)
                    q.add(new Pair<Integer>(i+1, p.b));
            } else {
                if (values[i] >= 0 && values[i] <= p.b)
                    q.add(new Pair<Integer>(values[i], p.b));
                if (p.a <= i-1)
                    q.add(new Pair<Integer>(p.a, i-1));
            }
        }
        if (!found)
            System.out.println("Not found");
        System.out.println("Took " + numIterations + " iterations");

        System.out.println((System.nanoTime()-startTime)/100000 + "ms");
    }
}
