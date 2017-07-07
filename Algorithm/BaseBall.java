public class BaseBall {


	public static void main(String[] args) {

		BaseBall baseBall = new BaseBall();

		String[] s = new String[]{"5", "-2", "4", "Z", "X", "9", "+", "+"};

		System.out.println(baseBall.getScore(s));
	}


	private double getScore(String[] arr) {

		if (arr == null || arr.length == 0) {
			return 0.0;
		}

		Stack<Double> stack = new Stack<>();

		double res = 0;

		for (String s : arr) {

			switch (s) {
				case "X":
					if (!stack.isEmpty()) {
						double x = stack.peek();
						stack.push(x * 2);
					}
					break;
				case "Z":
					if (!stack.isEmpty()) {
						stack.pop();
					}
					break;
				case "+":
					double a = 0;
					double b = 0;
					if (!stack.isEmpty()) {

						a = stack.pop();
					}
					if (!stack.isEmpty()) {

						b = stack.peek();
					}

					stack.push(a);
					stack.push(a + b);
					break;
				default:
					stack.push(Double.valueOf(s));
					break;

			}
		}

		while (!stack.isEmpty()) {
			res += stack.pop();
		}

		return res;

	}

}
