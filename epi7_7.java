import java.util.*;
public class epi7_7 {
	public static void main(String[] args) {
		final int[] list = {4,3,2,1,8,7,6,5,10,9};
		final int k = 3;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : list) {
				if (pq.size() == k+1)
					System.out.println(pq.poll());
				pq.add(x);
		}
		while (pq.size() > 0)
			System.out.println(pq.poll());
	}
}
