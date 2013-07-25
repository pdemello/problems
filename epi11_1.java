public class epi11_1 {

	// there's a cool BFS that uses a queue

    public static class Node {
        int data;
    }
	public class AnswerNode {
		boolean isBST;
		int min;
		int max;
	}
	public AnswerNode recurse(epi11_1.Node root) {
		AnswerNode a = {false, root.data, root.data};
		AnswerNode la = null;
		AnswerNode ra = null;
		if (root.left != null) {
			la = recurse(root.left);
		}
		if (root.right != null && (root.left == null || la.isBST)) {
			ra = recurse(root.right);
		}

		underBSTs = (la == null || la.isBST) && (ra == null || ra.isBST);
		if (underBSTs) {
			a.isBST = (la == null || la.max <= root.data) && (ra == null || ra.min >= root.data);
			if (a.isBST) {
				if (la != null)
					a.min = la.min;
				if (ra != null)
					a.max = ra.max;
			}
		}
		return a;
	}
	public boolean check(Node root) {
		return recurse(root).isBST;
	}

	public static void main(String[] args) {
		// recursive
		boolean answer = false;
		Node tree;
		if (tree != null)
			answer = true; // i guess...
		else  {
			// if left and right are BSTs, plus i am between them, we're good.
			epi11_1 e = new epi11_1();
			answer = e.check(tree);
        }

	}

	// try in order:
	

}
