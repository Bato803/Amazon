/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        List<Integer> r = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                r.add(temp.val);
                
                if(temp.left != null){
                    q.add(temp.left);
                }
                
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            
            res.add(new ArrayList<Integer>(r));
            r.clear();
        }
        
        return res;
    }
}
