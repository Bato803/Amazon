public class Distance {

	public static void main(String[] args) {

		int values[] = {5, 6, 3, 1, 2, 4};

		Distance distance = new Distance();

		System.out.println(distance.distance(values, 6, 2, 4));

	}


	private TreeNode root;

	private class TreeNode {


		int val;
		TreeNode left;
		TreeNode right;


		TreeNode(int val) {
			this.val = val;
		}


	}

	private void buildTree(int[] values, int n) {

		for (int i = 0; i < n; i++) {
			add(values[i]);
		}
	}

	private void add(int val) {

		if (root == null) {

			root = new TreeNode(val);
		} else {
			add(root, val);
		}
	}

	private void add(TreeNode root, int val) {

		if (val < root.val) {

			if (root.left == null) {
				root.left = new TreeNode(val);
			} else {
				add(root.left, val);
			}
		} else if (val > root.val) {

			if (root.right == null) {
				root.right = new TreeNode(val);
			} else {
				add(root.right, val);
			}

		}
	}

	private TreeNode helper(TreeNode root, int p, int q) {

		if (root == null || root.val == p || root.val == q) {
			return root;
		}

		TreeNode left = helper(root.left, p, q);

		TreeNode right = helper(root.right, p, q);

		if (left != null && right != null) {

			return root;
		}

		if (left != null) {
			return left;
		}

		if (right != null) {
			return right;
		}

		return null;
	}

	private int pathLengthHelp(TreeNode root, int n) {
		if (root != null) {
			int x = 0;
			if ((root.val == n) || (x = pathLengthHelp(root.left, n)) > 0
				|| (x = pathLengthHelp(root.right, n)) > 0) {
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	private int distance(int[] values, int n, int p, int q) {

		buildTree(values, n);

		TreeNode lowest = helper(root, p, q);

		int l1 = pathLengthHelp(root, p);
		int l2 = pathLengthHelp(root, q);
		int l = pathLengthHelp(root, lowest.val);

		return (l1 + l2) - (2 * l);


	}

}
