import utils.GraphNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class epi13_7 {
	public static void main(String[] args) {
        long startTime = System.nanoTime();

        final int n = 100;
        final int p = 10;
        final double maxHeight = 10.0;
        Double[][] teams = new Double[n][p];

        // Create my teams and sort the players on each team.
        for (int i = 0; i < teams.length; ++i) {
            for (int j = 0; j < teams[i].length; ++j) {
                teams[i][j] = maxHeight * Math.random();
            }
            // Sort in descending order:
            Arrays.sort(teams[i], (o1,o2) -> Double.compare(o2, o1));
            System.out.printf("Team\t%d:\t", i);
            for (double x : teams[i])
                System.out.printf("%.2f\t", x);
            System.out.println();
        }

        // Create my DAG.  Each team is a node.
        List<GraphNode<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < teams.length; ++i) {
            GraphNode<Integer> node = new GraphNode<>(i);
            graph.add(node);

        }


        System.out.printf("%d ms\n", (System.nanoTime()-startTime)/100000);
    }
}
