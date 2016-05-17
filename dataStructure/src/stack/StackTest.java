package stack;

public class StackTest {
	public static void main(String[] args) throws Exception {
		ArrayStack stack = new ArrayStack(5);
		
		stack.push("1");
		stack.push("2");
		System.out.println(stack.peek());
		stack.push("3");
		stack.push("4");
		stack.push("5");
		
		//stack.push("6");	// stack overflow
		
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		stack.pop();	// stack is empty 발생
		
	}
}
