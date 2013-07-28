import cafezinho.util.GraphNode;

import java.util.*;

public class epi13_7 {
	public static void main(String[] args) {
        long startTime = System.nanoTime();

        final int n = 100;
        final int p = 10;
        final double maxHeight = 10.0;
        Double[][] teams = new Double[n][p];

        // Create my teams and sort the players on each team.
        System.out.printf("All the teams:\n\n");
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

        // Create my DAG without any edges.  Each team is a node.
        List<GraphNode<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < teams.length; ++i)
            graph.add(new GraphNode<>(i));

        // Now create my edges.
        for (int i = 0; i < teams.length; ++i) {
            for (int j = i + 1; j < teams.length; ++j) {
                double heightDiff = 0.0;
                double prevDiff;
                boolean noGo = false;
                // Compare iTeam with jTeam.  We'll either add an edge from i to j, or j to i, or neither.
                // Compare players in each position... Bomb out if the "taller" team switches from one to the other.
                for (int player = 0; player < teams[j].length && !noGo; ++player) {
                    prevDiff = heightDiff;
                    heightDiff = teams[j][player] - teams[i][player]; // > 0 means j player is taller than i player.
                    if  (   heightDiff == 0
                        ||  prevDiff > 0 && heightDiff < 0
                        ||  prevDiff < 0 && heightDiff > 0)
                        noGo = true;  // The taller team has switched, these two can't be in the same photo.
                }
                if (!noGo)
                    graph.get(heightDiff > 0 ? j : i).getEdges().add(graph.get(heightDiff > 0 ? i : j));
            }
        }

        // DAG complete.  Now just need to find the longest path.  That is the answer.  Print out the graph in the meantime.
        System.out.printf("\nThe graph:\n\n");
        Map<GraphNode<Integer>, Integer> lengths = new HashMap<>(teams.length);
        int longestEdgeCount = 0;
        GraphNode<Integer> startNode = null;
        for (GraphNode<Integer> node : graph) {
            updateLengths(lengths, node);
            if (lengths.get(node) > longestEdgeCount) {
                startNode = node;
                longestEdgeCount = lengths.get(node);
            }
            System.out.printf("Team\t%d:\t", node.getData());
            for (GraphNode<Integer> edge : node.getEdges()) {
                System.out.printf("%d\t", edge.getData());
            }
            System.out.println();
        }

        // Now print out the answer, and show an example of that length.
        System.out.printf("\nLongest path is %d nodes.  One such path is:\n", longestEdgeCount+1);
        for (GraphNode<Integer> node = startNode; node != null; node = node.getPathway())
            System.out.println(node.getData());

        System.out.printf("\n%d ms\n", (System.nanoTime()-startTime)/100000);
    }

    private static void updateLengths(Map<GraphNode<Integer>, Integer> lengths, GraphNode<Integer> node) {
        if (!lengths.containsKey(node)) {
            int maxLength = 0;
            for (GraphNode<Integer> edge : node.getEdges()) {
                updateLengths(lengths, edge);
                int candidateMaxLength = 1 + lengths.get(edge);
                if (candidateMaxLength > maxLength) {
                    node.setPathway(edge);
                    maxLength = candidateMaxLength;
                }
            }
            lengths.put(node, maxLength);
        }
    }
}
