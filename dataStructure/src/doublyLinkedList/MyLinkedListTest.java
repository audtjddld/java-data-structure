package doublyLinkedList;

public class MyLinkedListTest {
	public static void main(String[] args) {
		MyLinkedList arr = new MyLinkedList();
		for (int i = 1; i <= 5; i++) {
			arr.add("데이터-" + i);
		}
		System.out.println(arr);

		System.out.println(arr.get(0));
		System.out.println(arr.get(3));

		arr.remove(3);
		System.out.println(arr);

		arr.add(1, "데이터-4");
		System.out.println(arr);

		arr.add("데이터-6");
		System.out.println(arr);
	}
}
