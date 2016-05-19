package queue;

public class ListQueue {
	private Node front;

	private Node rear;

	public ListQueue() {
		this.front = null;
		this.rear = null;
	}

	public boolean empty() {
		return (front == null);
	}

	public void insert(Object item) {
		Node node = new Node(item);
		node.nextNode = null;
		if (empty()) {
			rear = node;
			front = node;
		} else {
			rear.nextNode = node;	// 기존 rear에 nextNode에 새로 들어오는 node 주소를 넣고
			rear = node;			// 현재 등록된 rear에 새로 등록되는 node 주소를 넣는다. 줄이자면 뒤로 미는거다.
		}
	}

	public Object peek() {
		if (empty())
			throw new ArrayIndexOutOfBoundsException();
		return front.data;		// 현재 front가 가지고 있는 data를 가져온다.
	}

	public Object remove() {
		Object item = peek();		// 현재 데이터를 가져온 뒤
		front = front.nextNode;		// queue에 nextNode가 가리키던 node를 front에 다시 넣어준다.
		if (front == null) {		// front가  null일때는 아무것도 없는 상태이기 때문에 rear도 null로 만들어준다.
			rear = null;
		}
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
