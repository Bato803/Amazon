/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
     
    private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // write your code here
        

        
        if(root == null){
            
            return res;
        }
        
        helper(root);
        
        return res;
    }
    
    
    private int helper(TreeNode root){
        
        
        if(root == null){
            return 0;
            
        }
        
        int left = helper(root.left);
        
        int right = helper(root.right);
        
        
        int temp = Math.max(root.val, Math.max(root.val + left, root.val + right));
        res = Math.max(res, Math.max(temp, root.val + left + right));
        
        

        return temp;
    }
}
