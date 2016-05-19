package doublyLinkedList;

public class MyLinkedList {

	private Node header;

	private int size;

	public MyLinkedList() {
		header = new Node(null);
		size = 0;
	}

	public void addFirst(Object data) {
		Node newNode = new Node(data);
		newNode.nextNode = header.nextNode;
		if (header.nextNode != null) { 	// newNode가 첫 노드가 아닐 경우
			header.nextNode.previousNode = newNode;
		} else { 						// newNode가 첫 노드일 경우 newNode를 header의 이전 노드로 세팅
			header.previousNode = newNode;
		}
		header.nextNode = newNode;
		size++;
	}

	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}

		// singly list
		// Node node = header.nextNode;
		// for (int i = 0; i < index; i++) {
		// 		node = node.nextNode;
		// }
		// return node;

		// doubly list
		Node node = header;
		if (index < (size / 2)) {
			for (int i = 0; i <= index; i++) {
				node = node.nextNode;
			}
		} else {
			for (int i = size; i > index; i--) {
				node = node.previousNode;
			}
		}

		return node;
	}

	public Object get(int index) {
		return getNode(index).data;
	}

	public Object removeFirst() {
		Node firstNode = getNode(0);
		header.nextNode = firstNode.nextNode;
		if (header.nextNode != null) { // 삭제하고 남아있는 노드가 있을 경우
			firstNode.nextNode.previousNode = null;
		} else { // 삭제하고 남아있는 노드가 없을 경우
			header.previousNode = null;
		}
		size--;
		return firstNode.data;
	}

	public Object getFirst() {
		return get(0);
	}

	// ////////////////////////////////////////

	public void add(int index, Object data) {
		if (index == 0) {
			addFirst(data);
			return;
		}

		Node previous = getNode(index - 1);
		Node next = previous.nextNode;
		Node newNode = new Node(data);
		previous.nextNode = newNode;

		newNode.previousNode = previous;
		newNode.nextNode = next;

		if (newNode.nextNode != null) { // 삽입한 노드가 마지막 노드가 아닐 경우
			next.previousNode = newNode;
		} else { // 삽입한 노드가 마지막 노드일 경우
			header.previousNode = newNode;
		}
		size++;
	}

	public void addLast(Object data) {
		add(size, data);
	}

	public void add(Object data) {
		addLast(data);
	}

	public Object remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		} else if (index == 0) {
			return removeFirst();
		}

		Node removeNode = getNode(index);
		Node previous = removeNode.previousNode;
		Node next = removeNode.nextNode;

		previous.nextNode = next;
		if (next != null) { // 삭제한 노드가 마지막이 아닐 경우
			next.previousNode = previous;
		} else { // 삭제한 노드가 마지막일 경우
			header.previousNode = previous;
		}

		size--;
		return removeNode.data;
	}

	private int getNodeIndex(Object obj) {
		if (size <= 0) {
			return -1;
		}
		int index = 0;
		Node node = header.nextNode;
		Object nodeData = node.data;
		while (!obj.equals(nodeData)) {
			node = node.nextNode;
			if (node == null) {
				return -1;
			}
			nodeData = node.data;
			index++;
		}
		return index;
	}

	public boolean remove(Object data) {
		int nodeIndex = getNodeIndex(data);
		if (nodeIndex == -1) {
			return false;
		} else {
			remove(nodeIndex);
			return true;
		}
	}

	public Object removeLast() {
		return remove(size - 1);
	}

	public int size() {
		return size;
	}

	// ////////////////////////////////////////

	public String toString() {
		StringBuffer result = new StringBuffer("[");
		Node node = header.nextNode;
		if (node != null) {
			result.append(node.data);
			node = node.nextNode;
			while (node != null) {
				result.append(", ");
				result.append(node.data);
				node = node.nextNode;
			}
		}
		result.append("]");
		return result.toString();
	}

	private class Node {

		private Object data;

		private Node previousNode;

		private Node nextNode;

		Node(Object data) {
			this.data = data;
			this.previousNode = null;
			this.nextNode = null;
		}
	}
}
