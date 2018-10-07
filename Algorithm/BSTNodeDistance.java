package am;

public class BSTNodeDistance {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public int bstDistance(int[] numbers, int node1, int node2) {
        // Write your code here
        if (numbers == null || numbers.length == 0)
            return -1;

        int result = 0;
        boolean flag1 = false;
        boolean flag2 = false;

        TreeNode root = new TreeNode(numbers[0]);
        if (numbers[0] == node1) flag1 = true;
        if (numbers[0] == node2) flag2 = true;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == node1)
                flag1 = true;
            if (numbers[i] == node2)
                flag2 = true;

            constructBST(root, numbers[i]);
        }
        if (!(flag1 && flag2)) return -1;

        TreeNode LCA = findLCA(root, node1, node2);

        result = findDistance(LCA, node1) + findDistance(LCA, node2);

        return result;
    }

    public void constructBST(TreeNode root, int node) {
        if (root.val > node) {
            if (root.left == null) {
                root.left = new TreeNode(node);
            } else {
                constructBST(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(node);
            } else {
                constructBST(root.right, node);
            }
        }
    }

    public TreeNode findLCA(TreeNode root, int node1, int node2) {
        if (node1 < root.val && node2 < root.val) {
            return findLCA(root.left, node1, node2);
        }
        if (node1 > root.val && node2 > root.val) {
            return findLCA(root.right, node1, node2);
        } else {
            return root;
        }
    }

    public int findDistance(TreeNode root, int node) {
        if (root.val == node) {
            return 0;
        }
        if (root.val < node) {
            return findDistance(root.right, node) + 1;
        } else {
            return findDistance(root.left, node) + 1;
        }
    }
}
