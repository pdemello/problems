import java.util.Arrays;

public class epi8_3 {
	public static void main(String[] args) {
        long startTime = System.nanoTime();

        // First, generate a list of n random integers, sorted in ascending order
        // Let's say the values can range from -n to 2n.
        final int n = 100; // Length of array
        final int range = 3; // Range of random numbers.  3 means range of -n to 2n.
        int[] values = new int[n];
        for (int i = 0; i < n; ++i) {
            values[i] = (int)(range * n * Math.random() + .5) - n;
        }
        Arrays.sort(values);
        for (int i = 0; i < values.length; ++i) {
            System.out.println(i + "\t" + values[i]);
        }


        // Now solve the problem.

        System.out.println((System.nanoTime()-startTime)/100000 + "ms");
    }
}
