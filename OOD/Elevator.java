public enum Status {

	RUN,IDLE
}

public enum Action {

	UP, DOWN;
}

public interface Command {

	void execute();
}


public class CommandUpAndDown implements Command {

	private ElevatorCar elevator;
	private Request request;

	public CommandUpAndDown(ElevatorCar elevator, Request request){
		this.elevator = elevator;
		this.request = request;
	}

	@Override
	public void execute() {
		elevator.processRequest(request);
	}

}

public class Request {
	private long time;
	private Integer floor;
	private Action action;

	public Request(long time, Integer floor, Action action) {
		this.time = time;
		this.floor = floor;
		this.action = action;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
}


public class ElevatorCar {


	private PriorityQueue<Request> upQueue = new PriorityQueue<>(new UpComparator());
	private PriorityQueue<Request> downQueue = new PriorityQueue<>(new DownComparator());
	private PriorityQueue<Request> curQueue = new PriorityQueue<>();

	private Action action;
	private Status status;

	private Thread thread;

	private int currFloor;

	private long upRequestTime;
	private long downRequestTime;

	synchronized void processRequest(Request request) {

		if (status == Status.IDLE) {

			if (currFloor > request.getFloor()) {

				curQueue = new PriorityQueue<>(new DownComparator());
			} else {
				curQueue = new PriorityQueue<>(new UpComparator());
			}

			curQueue.add(request);

			status = Status.RUN;
			thread = new Thread(new Process());
			thread.start();


		} else {

			if (request.getAction() == Action.DOWN) {

				if (action == Action.DOWN) {

					if (request.getFloor() < currFloor) {
						curQueue.add(request);
					} else {
						upQueue.add(request);
					}
				} else {

					upQueue.add(request);

				}

				downRequestTime = Math.min(downRequestTime, request.getTime());
			} else {

				if (action == Action.UP) {

					if (request.getFloor() > currFloor) {
						curQueue.add(request);
					} else {
						downQueue.add(request);
					}
				} else {

					downQueue.add(request);

				}

				upRequestTime = Math.min(upRequestTime, request.getTime());

			}
		}

	}

	private void preProcessNextQueue() {

		if (downRequestTime < upRequestTime) {

			action = Action.DOWN;
			curQueue = downQueue;

			downQueue.clear();
			downRequestTime = Long.MAX_VALUE;
		} else {
			
			action = Action.UP;
			curQueue = upQueue;

			upQueue.clear();
			upRequestTime = Long.MAX_VALUE;
		}
	}


	private class DownComparator implements Comparator<Request> {

		@Override
		public int compare(Request o1, Request o2) {
			return o2.getFloor() - o1.getFloor();
		}
	}

	private class UpComparator implements Comparator<Request> {

		@Override
		public int compare(Request o1, Request o2) {
			return o1.getFloor() - o2.getFloor();
		}
	}


	private synchronized void process() {

		while (!curQueue.isEmpty()) {

			Request request = curQueue.poll();

			if (request.getAction() == Action.DOWN) {
				System.out.println(request.getAction() + " " + (currFloor - request.getFloor()));

				currFloor = request.getFloor();
			} else {
				System.out.println(request.getAction() + " " + (request.getFloor() - currFloor));

				currFloor = request.getFloor();
			}
		}
		if (curQueue.isEmpty()) {
			preProcessNextQueue();
		}


	}

	private class Process implements Runnable {

		@Override
		public void run() {
			process();
		}
	}
}
