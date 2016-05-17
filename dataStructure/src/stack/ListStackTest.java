package stack;

public class ListStackTest {
	public static void main(String[] args) throws Exception {
		ListStack stack = new ListStack();
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}

		stack.push(6);

		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println(stack.peek());
		System.out.println(stack.peek());

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}
}
