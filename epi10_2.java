import java.util.Arrays;

public class epi10_2 {

    // Ok.. just use an indirect sort....

	public static void main(String[] args) {
        long startTime = System.nanoTime();

        // First, generate a list of n random integers
        // Let's say the values can range from -n to 2n.
        final int n = 100; // Length of array
        final double range = 1.6; // Range of random numbers.  3 means range of -n to 2n.
        final double underhang = .33333;
        Integer[] values = new Integer[n];
        for (int i = 0; i < n; ++i) {
            values[i] = (int)(n * (range * Math.random() - underhang) + .5);
        }
        //Arrays.sort(values);
        for (int i = 0; i < values.length; ++i) {
            System.out.println(i + "\t" + values[i]);
        }

        //mergeSort(values, 0, values.length);

        System.out.println((System.nanoTime()-startTime)/100000 + "ms");
    }
}
