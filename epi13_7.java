import java.util.Arrays;

public class epi13_7 {
	public static void main(String[] args) {
        long startTime = System.nanoTime();

        final int n = 100;
        final int p = 10;
        final double maxHeight = 10.0;
        double[][] teams = new double[n][p];
        for (int i = 0; i < teams.length; ++i) {
            for (int j = 0; j < teams[i].length; ++j) {
                teams[i][j] = maxHeight * Math.random();
            }
            Arrays.sort(teams[i]);
            System.out.printf("Team\t%d:\t", i);
            for (double x : teams[i])
                System.out.printf("%.2f\t", x);
            System.out.println();
        }

        System.out.printf("%d ms\n", (System.nanoTime()-startTime)/100000);
    }
}
