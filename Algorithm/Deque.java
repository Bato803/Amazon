public class Deque {


	public static void main(String[] args) {

		Deque deque = new Deque();

		deque.add(4);
		deque.add(3);
		deque.add(2);
		deque.add(1);
		deque.addTail(5);
		deque.addTail(6);
		deque.addTail(7);
		deque.addTail(8);

		System.out.println(deque.get(7));
	}


	ArrayList<Integer> head = new ArrayList<>();

	ArrayList<Integer> tail = new ArrayList<>();


	private void add(int i) {
		head.add(i);
	}

	private void addTail(int i) {

		tail.add(i);

	}


	private int get(int index) {

		if (index >= head.size()) {
			return tail.get(index - head.size());
		} else {
			return head.get(head.size() - index - 1);
		}

	}


}
