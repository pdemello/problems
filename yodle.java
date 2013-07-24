import java.io.*;
import java.util.*;

public class yodle {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		try {

			// First read from file
			BufferedReader r = new BufferedReader(new FileReader(args[0]));
			String line = null;
			Map<String,Integer> m = new HashMap<String,Integer>();
			while ((line = r.readLine()) != null) {
				// Tokenize I guess?
				String[] words = line.split("[^a-zA-Z]");
				for (String s : words) {
					if (s.length() > 0) {
						String lc = s.toLowerCase();
						m.put(lc, m.containsKey(lc) ? m.get(lc) + 1 : 1);
					}
				}
			}

			// Then sort by wordcount
			TreeSet<Map.Entry<String,Integer>> ts = new TreeSet<Map.Entry<String,Integer>>(
				new Comparator<Map.Entry<String,Integer>>() {
					public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
						if (o1.getValue() == o2.getValue())
							return o1.getKey().compareTo(o2.getKey());
						else
							return o2.getValue() - o1.getValue();
					}
					public boolean equals(Object o) {
						return this == o;
					}
				});

			ts.addAll(m.entrySet());
			
			// Then pretty-print the output
			for (Map.Entry<String,Integer> me : ts) {
				System.out.println(me.getKey() + "\t" + me.getValue());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println((System.nanoTime()-startTime)/100000 + "ms");
	}
}

// What's the best way to tokenize a string?
// What's the best way to deal with the sorting?

