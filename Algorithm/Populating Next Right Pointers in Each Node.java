/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        if(root == null){
            return;
        }
        
        
        if(root != null){
            
            if(root.left != null){
                
                root.left.next = root.right;
            }
            
            if(root.right != null && root.next != null){
                
                root.right.next = root.next.left;
            }
        }
        
        connect(root.left);
        connect(root.right);
        
    }
}


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        if(root == null){
            
            return;
        }
        
        
        Queue<TreeLinkNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            List<TreeLinkNode> list = new LinkedList<>();
            
            for(int i = 0; i < size; i++){
                
                TreeLinkNode temp = q.poll();
                
                list.add(temp);
                
                if(temp.left != null){
                    
                    q.add(temp.left);
                }
                
                if(temp.right != null){
                    
                    q.add(temp.right);
                }
                
                
            }
            
            TreeLinkNode curr = list.get(0);
            
            for(int i = 1; i < list.size(); i++){
                
                TreeLinkNode next = list.get(i);
                
                curr.next = next;
                
                curr = next;
            }
        }
        
        return;
        
        
    }
}
