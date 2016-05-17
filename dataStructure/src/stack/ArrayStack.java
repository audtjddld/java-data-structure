package stack;

public class ArrayStack {
	// 제일 마지막에 저장한 데이터를 가장 먼저 꺼내는 방법으로 LIFO(List In First Out) 형태의 자료 구조.
	// 객체 지향이기 때문에 stack을 배열로 구현할 때 어떤 것들이 있는지 생각해보자.
	// Array 객체 와 배열 size 가 필요하다.
	// top = 읽기, 삽입, 삭제가 일어나는 위치 
	// 따라서 top은 -1 부터 시작해야 한다. top 증가 후 삽입 , 읽기 시 해당 위치에 데이터를 읽는 수 있어야 하기 때문에. 삽입 후 등록이면 잘못한거다.
	// bottom = 바닥에 깔린 데이터 이고 0으로 고정 값이다.
	// 동작 : 삽입 (push), 삭제 (pop), 읽기(peek)
	/*
		초기값 top = 0
		
		삽입 동작 ( top < size -1 ) 일때만 동작
		
		if( top < size -1 )
		top = top + 1
		array[top] = data;
	 */
	/*
		읽기 (top > -1)  
		if (top != -1)
		return array[top];
	 */
	/*
		삭제	(top > -1)
		
			읽기
			if( top != -1 )
			top = top - 1;
	 */
	private int top;
	private Object[] array;
	private int size;
	
	ArrayStack (int size) {
		this.size = size;
		this.array = new Object[size];
		this.top = -1;
	}
	
	/**
	 * 삽입
	 * @author 정명성
	 * @create date : 2016. 5. 17.
	 * @param data
	 * @throws Exception
	 */
	public void push(Object data) throws Exception {
		if(top == size -1) {
			throw new Exception("stack overflow");
		}
		top++;
		array[top] = data;
	}
	
	/**
	 * 읽기
	 * @author 정명성
	 * @create date : 2016. 5. 17.
	 * @return
	 * @throws Exception
	 */
	public Object peek() throws Exception {
		if(top < 0) {
			throw new Exception("stack is empty");
		}
		return array[top];
	}
	
	/**
	 * 삭제
	 * @author 정명성
	 * @create date : 2016. 5. 17.
	 * @throws Exception
	 */
	public void pop() throws Exception {
		peek();
		top--;
	}
}

