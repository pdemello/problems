import java.io.*;
import java.util.*;

// This is the file I will update from now on, post uploading everything to github.
// Test to see if IDEA Git integration works.

public class yodle3 {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		try {

			// First read from file
            // Wow this scanner is a lot slower than the Buffered reader stuff...
            Map<String,Integer> m = new HashMap<String,Integer>();
            Scanner sc = new Scanner(new BufferedReader(new FileReader(args[0])));
            sc.useDelimiter("[^a-zA-Z]");
            while (sc.hasNext()) {
                String s = sc.next();
                if (s.length() > 0) {
                    String lc = s.toLowerCase();
                    m.put(lc, m.containsKey(lc) ? m.get(lc) + 1 : 1);
                }
            }
			sc.close();

			PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<Map.Entry<String,Integer>>(m.size(),
                new Comparator<Map.Entry<String,Integer>>() {
                    public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
                        if (o1.getValue().equals(o2.getValue()))
                            return o1.getKey().compareTo(o2.getKey());
                        else
                            return o2.getValue() - o1.getValue();
                    }
                });
			for (Map.Entry<String,Integer> me : m.entrySet()) {
				pq.add(me);
			}

			// Then pretty-print the output
			while (pq.size() > 0) {
				Map.Entry<String,Integer> me = pq.poll();
				System.out.println(me.getKey() + "\t" + me.getValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println((System.nanoTime()-startTime)/100000 + "ms");
	}
}

// What's the best way to deal with the sorting?
