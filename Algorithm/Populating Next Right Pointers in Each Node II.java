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
        
        TreeLinkNode curr = root;
        TreeLinkNode prev = null;
        TreeLinkNode head = null;
      
        
        
        while(curr != null){
            
            
            while(curr != null){
                
                
                if(curr.left != null){
                    
                    if(prev != null){
                        prev.next = curr.left;
                    }else{
                        head = curr.left;
                    }
                    
                    prev = curr.left;
                    
                }
                
                if(curr.right != null){
                    
                    if(prev != null){
                        prev.next = curr.right;
                    }else{
                        head = curr.right;
                    }
                    
                    prev = curr.right;
                    
                }
                
                curr = curr.next;
            }
            
            curr = head;
            head = null;
            prev = null;

            
        }
    }
}
