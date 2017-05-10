public class Solution {
    public boolean isValid(String s) {
        
        
        if(s == null || s.length() == 0){
            
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        
        int i = 0;
        
        while(i < s.length()){
            
            char c = s.charAt(i);
            
            if(c == ')' || c == ']' || c == '}'){
                
                if(stack.isEmpty()){
                    
                    return false;
                }
                
                if((c == ')' && stack.pop() != '(') || (c == ']' && stack.pop() != '[') || (c == '}' && stack.pop() != '{')){
                    return false;
                }
                
            }else{
                stack.push(c);
            }
            
            i++;
            
        }
        
        return stack.isEmpty();
        
        
        
    }
}
