package doublyLinkedList;

/**
 * 큐 Queue
 * @author 정명성
 * @create date : 2016. 5. 18.
 * doubleLinkedList.DoubleLinkedList.java
 */
public class DoublyLinkedList {

	private Header header;

	private int size;

	DoublyLinkedList() {
		this.header = new Header();
		this.size = 0;
	}

	private class Node {
		private Object data;

		private Node nextNode;

		Node(Object data) {
			this.data = data;
			this.nextNode = null;
		}
	}

	private class Header {
		private Node nextNode;

		private Node lastNode;
		Header() {
			this.nextNode = null;
			this.lastNode = null;
		}
	}

	public void addFirst(Object data) {
		Node newNode = new Node(data);

		newNode.nextNode = header.nextNode;
		header.nextNode = newNode;

		if (newNode.nextNode == null) {
			header.lastNode = newNode;
		}

		size++;
	}

	/**
	 * 데이터 추가
	 * 
	 * @author 정명성
	 * @create date : 2016. 5. 18.
	 * @param index
	 * @param data
	 */
	public void add(int index, Object data) {
		if (index == 0) {
			addFirst(data);
			return;
		} else if (index == size) {
			addLast(data);
		} else {
			Node previous = getNode(index - 1);
			Node next = previous.nextNode;
			Node newNode = new Node(data);
			previous.nextNode = newNode;
			newNode.nextNode = next;
			size++;
		}

	}

	public void addLast(Object data) {
		if (header.lastNode == null) {
			add(size, data);
		} else {
			Node newNode = new Node(data);
			header.lastNode.nextNode = newNode;
			header.lastNode = newNode;
			size++;
		}

	}

	public void add(Object data) {
		addLast(data);
	}

	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index : " + index + ", size :" + size);
		}

		Node node = header.nextNode;
		for (int i = 0; i < index; i++) {
			node = node.nextNode;
		}

		return node;
	}

	/**
	 * 데이터 가져오기
	 * 
	 * @author 정명성
	 * @create date : 2016. 5. 18.
	 * @param index
	 * @return
	 */
	public Object get(int index) {
		return getNode(index).data;
	}

	public Object removeFirst() {
		Node firstNode = getNode(0);
		header.nextNode = firstNode.nextNode;
		size--;
		if (header.nextNode == null) {
			header.lastNode = null;
		}
		return firstNode.data;
	}

	public Object remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index :" + index + ", size : " + size);
		} else if (index == 0) {
			return removeFirst();
		}

		Node previous = getNode(index - 1);
		Node removeNode = previous.nextNode;
		Node next = removeNode.nextNode;
		previous.nextNode = next;
		size--;

		if (previous.nextNode == null) {
			header.lastNode = previous;
		}

		return removeNode.data;
	}

	public int getNodeIndex(Object obj) {
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
}
