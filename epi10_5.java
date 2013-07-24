import java.util.*;

public class epi10_5 {
	public static int binSearch(int[] a, int l, int u, int x) {
		int ret = -1;
		while (l <= u) {
			int i = l + (u - l) / 2;
			System.out.println("binSearch: comparing " + a[i] + " and " + x);
			if (a[i] == x) {
				ret = i;
				break;
			} else if (a[i] > x) {
				ret = i;
				u = i - 1;
			} else
				l = i + 1;
		}
		return ret;
	}	
	public static void main(String[] args) {
		int[] a1 = {5};
		int[] a2 = {4,5,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28};
		int a1l = 0;
		int a2l = 0;
		List<Integer> ret = new ArrayList<Integer>();
		while (a1l >= 0 && a2l >= 0 && a1l < a1.length && a2l < a2.length) {
			System.out.println("main:      comparing " + a1[a1l] + " and " + a2[a2l]);
			if (a1[a1l] == a2[a2l]) {
				ret.add(a1[a1l]);
				++a1l; ++a2l;
			} else if (a1[a1l] > a2[a2l])
				a2l = binSearch(a2, a2l+1, a2.length-1, a1[a1l]);
			else
				a1l = binSearch(a1, a1l+1, a1.length-1, a2[a2l]);
		}
		for (int i : ret)
			System.out.println(i);
	}
}
