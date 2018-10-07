/*
Description
Given a BST, find the path with the minimum sum from root to leaves.

Have you met this question in a real interview?  
Example
Input:{5,2,6,#,3,#,8}
Output:10

*/

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
     * @param root: the root
     * @return: minimum sum
     */
    public int minimumSum(TreeNode root) {
        // Write your code here
        
        
        
        return helper(root);
    }
    
    
    private int helper(TreeNode root){
        
        if(root == null){
            
            return 0;
        }
        
        
        if(root.left == null && root.right == null){
            
            return root.val;
        }
        
        
        
        
        if(root.left == null){
            
            return root.val + helper(root.right);
            
        }
        
        if(root.right == null){
            
            return root.val + helper(root.left);
        }
        
        
        return root.val + Math.min(helper(root.left), helper(root.right));
    }
}

