public class epi8_2 {
	public static void main(String[] args) {

		int[] arr = {-14, -10, 2, 108, 108, 243, 285, 285, 285, 285, 285, 285, 285, 285, 285, 285, 285, 285, 401};

		int l = 0;
		int u = arr.length - 1;
		int x = 284;
		int rval = -1;
		boolean found = false;
		if (arr != null && arr.length > 0)
			while (l <= u) {
				int i = l + (u-l)/2;
				if (arr[i] > x) {
					rval = i;
					u = i - 1;
				}
				else
					l = i + 1;
			}
		System.out.println(rval);
	}
}
