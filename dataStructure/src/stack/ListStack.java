package stack;

public class ListStack {
	private Node top;
	
	public ListStack() {
		this.top = null;
	}
	
	public void push(Object item) {
		Node newNode = new Node(item);
		newNode.nextNode = top;
		top = newNode;
	}
	
	public Object peek() throws Exception {
		if(top == null) throw new Exception("stack is empty.");
		return top.data;
	}
	
	public Object pop() throws Exception {
		Object item = peek();
		top = top.nextNode;
		return item;
	}
	
	private class Node {
		private Object data;
		private Node nextNode;
		Node(Object data) {
			this.data = data;
			this.nextNode = null;
		}
	}
}
