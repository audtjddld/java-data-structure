package stack;

public class ArrayStackTest {
	public static void main(String[] args) throws Exception {
		ArrayStack stack = new ArrayStack(5);
		
		stack.push("1");
		stack.push("2");
		//Assert.assertEquals(stack.peek(), "2");
		System.out.println(stack.peek());
		stack.push("3");
		stack.push("4");
		stack.push("5");
		
		//stack.push("6");	// stack overflow
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());	// stack is empty 발생
	}
}
