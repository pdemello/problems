public class epi4_1 {
	public static class Node<T> {
		public T data;
		public Node<T> next;
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
	public static <T> Node<T> buildList(T[] arr) {
		Node<T> head = null;
		Node<T> tail = null;
		for (T x : arr) {
			Node<T> node = new Node<T>(x, null);
			if (head == null)
				head = node;
			else
				tail.next = node;
			tail = node;
		}
		return head;
	}
	public static <T> void traverseList(Node<T> head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	public static void main(String[] args) {
		Integer[] a1 = {1,3,5,7,9};
		Integer[] a2 = {6};
		Node<Integer> l1 = buildList(a1);
		Node<Integer> l2 = buildList(a2);
		traverseList(l1);
		System.out.println("----");
		traverseList(l2);

		Node<Integer> l3 = null;
		Node<Integer> t3 = null;
		while (l1 != null || l2 != null) {
			Node<Integer> toAdd = null;
			if (l1 == null)
				toAdd = l2;
			else if (l2 == null)
				toAdd = l1;
			else
				toAdd = l1.data < l2.data ? l1 : l2;
			if (toAdd == l1)
				l1 = l1.next;
			else
				l2 = l2.next;
			if (l3 == null)
				l3 = toAdd;
			else
				t3.next = toAdd;
			t3 = toAdd;
		}

		System.out.println("---------------");
		traverseList(l3);
	}
}
