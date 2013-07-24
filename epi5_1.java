public class epi5_1 {

	// This has an improved answer in the back


	public class Stack {
		private int[] stack = new int[256];
		private int top = -1;
		private int[] maxes = new int[256];
		public void push(int x) {
			if (top == stack.length - 1)
				throw new ArrayIndexOutOfBoundsException();
			++top;
			maxes[top] = (top == 0 || x > maxes[top-1]) ? x : maxes[top-1];
			stack[top] = x;
		}
		public int pop() {
			if (isEmpty())
				throw new ArrayIndexOutOfBoundsException();
			return stack[top--];
		}
		public boolean isEmpty() {
			return top < 0;
		}
		public int max() {
			if (isEmpty())
				throw new ArrayIndexOutOfBoundsException();
			return maxes[top];
		}
	}
	public void meat() {
		Stack s = new Stack();
		s.push(4);
		s.push(1);
		s.push(8);
		System.out.println(s.max());
		System.out.println(s.pop());
        System.out.println(s.max());
		System.out.println(s.pop());
        System.out.println(s.max());
		System.out.println(s.pop());
	}

	public static void main(String[] args) {
		epi5_1 e = new epi5_1();
		e.meat();
	}
}
