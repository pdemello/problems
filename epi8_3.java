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
        final int n = 100000; // Length of array
        final double range = 1.6; // Range of random numbers.  3 means range of -n to 2n.
        final double underhang = .33333;
        int[] values = new int[n];
        for (int i = 0; i < n; ++i) {
            values[i] = (int)(n * (range * Math.random() - underhang) + .5);
        }
        Arrays.sort(values);
        /*
        for (int i = 0; i < values.length; ++i) {
            System.out.println(i + "\t" + values[i]);
        }*/

        // At this point, our array has decent input.
        // Now solve the problem.

        Queue<Pair<Integer>> q = new ArrayDeque<Pair<Integer>>();
        q.add(new Pair<Integer>(0, n-1));  // Let's use .a as bottom and .b as top
        int numIterations = 0;
        boolean found = false;
        while (!q.isEmpty() && numIterations < n) {
            ++numIterations;
            Pair<Integer> p = q.remove();
            int i = p.a + (p.b - p.a) / 2;
            System.out.println("Checking index " + i + " : " + values[i]);
            if (values[i] == i) {
                found = true;
                System.out.println("Found:  " + i);
                break;
            } else if (i > values[i]) {
                int valueIndex = Math.min(values[i], values.length-1);
                if (p.a <= valueIndex) {
                    q.add(new Pair<Integer>(p.a, valueIndex));
                    System.out.println("Added " + p.a + " " + valueIndex);
                }
                if (i+1 <= p.b) {
                    q.add(new Pair<Integer>(i+1, p.b));
                    System.out.println("Added " + (i+1) + " " + p.b);

                }
            } else {
                int valueIndex = Math.max(values[i], 0);
                if (valueIndex <= p.b) {
                    q.add(new Pair<Integer>(valueIndex, p.b));
                    System.out.println("Added " + valueIndex + " " + p.b);

                }
                if (p.a <= i-1) {
                    q.add(new Pair<Integer>(p.a, i-1));
                    System.out.println("Added " + p.a + " " + (i-1));

                }
            }
        }
        if (!found)
            System.out.println("Not found");
        System.out.printf("Took %d iterations\n", numIterations);

        System.out.println((System.nanoTime()-startTime)/100000 + "ms");
    }
}
