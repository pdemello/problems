public class epi7_1 {
	public static void main(String[] args) {


// i get the gist.  moving on.

		// 500 arrays
		// read all files first lines, and put them into a heap
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		List<Node> ret = new ArrayList<Node>();
		for (List l : lists)
			if (l != null) {
				Node n = l.get(0);
				if (n != null)
					pq.add(n);
			}
		while (pq.peek())
			Node n = pq.poll();
			ret.add(pq.poll());
		}
	}
}

class Node implements Comparable {
	public int time;
	public String line;
	public int compareTo(Node n) {
		return time - n.time;
}
