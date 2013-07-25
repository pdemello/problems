public class epi6_5 {

// I'm on the right track.  moving on.

	public static void main(String[] args) {
		Node last = null;
		while (n != null) {

			if (last == null || last.left == n || last.right == n)
				if (n.left != null) {
					// go left
					last = n;
					n = n.left;
                }
				else
					System.out.println(n.data);
			else if ((last == n.left && last != null) || (n.left == null && (n.right != last || n.right == null))) {
				// print and go right if possible
				System.out.println(n.data);
				last = n;
				n = n.right == null ? n.parent : n.right;
            }
			else {
				// go up
				last = n;
				n = n.parent;
            }
        }
	}
}
