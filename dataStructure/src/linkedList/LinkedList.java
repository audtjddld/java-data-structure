package linkedList;

public class LinkedList {
	private Node header;

	private int size;

	public LinkedList() {
		header = new Node(null);
		size = 0;
	}

	/**
	 * 지정한 인덱스의 노드를 반환한다.
	 * 
	 * @param index
	 * @return
	 */
	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
		// TODO 지정한 인덱스의 노드를 찾아서 반환한다.
		Node result = header.nextNode;
		for (int i = 0; i < index; i++) {
			result = result.nextNode;
		}
		return result;
	}

	/**
	 * 리스트의 처음에 지정한 데이터를 삽입한다.
	 */
	public void addFirst(Object data) {
		// TODO 지정한 데이터를 가지는 노드를 만든 후 리스트의 처음에 삽입하고 사이즈 증가
		Node newNode = new Node(data);
		newNode.nextNode = header.nextNode;
		header.nextNode = newNode;
		size++;
	}

	/**
	 * 지정한 인덱스에 데이터를 삽입한다.
	 */
	public void add(int index, Object data) {
		// TODO 인덱스가 0일 경우 리스트의 처음에 지정한 데이터를 삽입한다.
		if (index == 0) {
			addFirst(data);
			return;
		}
		// TODO 지정한 인덱스의 이전 노드와 해당 노드를 찾은 후 새로운 노드를 만들어 삽입하고 사이즈 증가
		Node newNode = new Node(data);
		Node previous = getNode(index - 1);
		Node next = previous.nextNode;
		newNode.nextNode = next;
		previous.nextNode = newNode;
		size++;
	}

	/**
	 * 리스트의 마지막에 데이터를 추가한다.
	 */
	private void addLast(Object data) {
		// TODO 마지막 인덱스에 데이터를 삽입한다.
		add(size, data);
	}

	/**
	 * 지정한 인덱스의 데이터를 반환한다.
	 */
	public Object get(int index) {
		// TODO 지정한 인덱스의 노드를 찾은 후 찾은 노드의 데이터를 반환한다.
		return getNode(index).data;
	}

	/**
	 * 리스트의 마지막에 데이터를 추가한다.
	 */
	public void add(Object data) {
		// TODO 리스트의 마지막에 데이터를 추가한다.
		addLast(data);
	}

	/**
	 * 리스트의 첫번째 요소를 삭제하여 반환한다.
	 */
	private Object removeFirst() {
		// TODO 첫번째 노드의 다음 노드를 첫번째 노드로 지정하고 첫번째 노드의 데이터를 반환한 후 사이즈 감소
		Node firstNode = getNode(0);
		header.nextNode = firstNode.nextNode;
		size--;
		return firstNode.data;
	}

	/**
	 * 지정한 인덱스의 데이터를 삭제한 후 삭제한 데이터를 반환한다.
	 */
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
		return removeNode.data;
	}

	public int size() {
		return size;
	}

	/**
	 * 연결리스트의 모든 요소를 문자열로 반환한다.
	 */
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

	/**
	 * 연결리스트의 구성 요소인 노드 클래스
	 *
	 */
	private class Node {
		/**
		 * 저장할 객체
		 */
		private Object data;

		/**
		 * 다음 노드의 참조 변수
		 */
		private Node nextNode;

		Node(Object data) {
			this.data = data;
			this.nextNode = null;
		}
	}

}
