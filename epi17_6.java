import java.util.*;

public class epi17_6 {
	public static void main(String[] args) {
		final int k = 7;
		Map<Integer,Date> m = new HashMap<Integer,Date>();
		for (int i = 0; i < k; ++i) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			m.put(i, new Date());
		}
		for (Date d : m.values()) {
			System.out.println(d.getTime());
		}
		int i = k;
		while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

			// "read" packet.  only insert it if we delete one.
			Date d = new Date();
			int delIdx = (int)(0.5 + (i * Math.random()));
			boolean removed = false;
			if (delIdx < i) {
				// If we find this in the map, delete and add the new packet.
				if (m.remove(delIdx) != null) {
					System.out.println("Removing " + delIdx + " and adding " + i);
					m.put(i, d);
					removed = true;
				}
			}
			if (!removed)
				System.out.println("No " + delIdx + " for " + i);

			// print status
        	for (Map.Entry<Integer,Date> e : m.entrySet()) {
        	    System.out.println(e.getKey() + "\t" + e.getValue().getTime());
        	}
			++i;
        }
	}
}
