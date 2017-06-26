public class Solution {
    
    
    
    class Node{
     
        char c;
        int count;
        
        
        Node(char c, int count){
            
            this.c = c;
            this.count = count;
        }
    }
    
    public String frequencySort(String s) {
        
        if(s == null || s.length() == 0){
            return "";
        }
        
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
             
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
            
                map.put(c, map.get(c) + 1);
            }
        }
        
        
        List<Node> list = new ArrayList<>();
        
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            
            char key = entry.getKey();
            int value = entry.getValue();
            
            list.add(new Node(key, value));
            
        }
        
        Collections.sort(list, (o1, o2) -> o2.count - o1.count);
        
        
        StringBuilder sb = new StringBuilder();
        
        
        for(Node node : list){
            
            int count = node.count;
            
            while(count > 0){
                
     
                sb.append(node.c);
                count--;
            }
            
        }
        
        return sb.toString();
        
        
        
        
        
    }
}
