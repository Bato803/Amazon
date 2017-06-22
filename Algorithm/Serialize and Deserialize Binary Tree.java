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
    
    private String nullPointer = "x";
    private String spliter = ",";
    
    public String serialize(TreeNode root) {
        
        if(root == null){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
    
        buildString(root, sb);
        
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb){
        
        
        if(root != null){
            sb.append(root.val).append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }else{
            sb.append(nullPointer).append(spliter);
        }
        

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == null || data.isEmpty()){
            return null;
        }
        
        
        String[] arr = data.split(spliter);
        
        Queue<String> q = new LinkedList<>();
        
        for(String s : arr){
            q.add(s);
        }
        
        return buildTree(q);
        
        
    }
    
    private TreeNode buildTree(Queue<String> q){
        
        if(!q.isEmpty()){
            
            String s = q.poll();
            
            if(s.equals(nullPointer)){
                
                return null;
            }else{
                
                TreeNode root = new TreeNode(Integer.valueOf(s));
                
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
