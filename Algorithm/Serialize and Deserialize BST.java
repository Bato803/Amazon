/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    
    private String spliter = ",";
    private String nullPointer = "X";
    
    public String serialize(TreeNode root) {
        
        
        if(root == null){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        buildString(root, sb);
        
        return sb.toString();
        
    }
    
    private void buildString(TreeNode root, StringBuilder sb){
        
        
        if(root == null){
            sb.append(nullPointer).append(spliter);
        }else{
            sb.append(root.val).append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        
        if(data == null || data.length() == 0){
            return null;
        }
        
        
        Queue<String> q = new LinkedList<>();
        
        for(String s : data.split(spliter)){
            
            q.add(s);
        }
        
        return buildTree(q);
    }
    
    private TreeNode buildTree(Queue<String> q){
        
        if(!q.isEmpty()){
            
            String poll = q.poll();
            
            if(poll.equals(nullPointer)){
                
                return null;
            }else{
                
                TreeNode  root = new TreeNode(Integer.valueOf(poll));
                
                root.left = buildTree(q);
                root.right = buildTree(q);
                
                
                return root;
            }
        }
        
        return null;
        
          
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
