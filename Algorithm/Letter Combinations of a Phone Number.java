public class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<>();
        
        if(digits == null || digits.length() == 0){
            
            return res;
        }
        
        String[] map = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv","wxyz"};
        
        
        helper(digits, map, new StringBuilder(), res, 0);
        
        return res;
        
    }
    
    private void helper(String digits, String[] map, StringBuilder sb, List<String> res, int pos){
        
        if(pos == digits.length()){
            res.add(sb.toString());
            return;
        }
    
    
        String s = map[digits.charAt(pos) - '0'];
        
        for(int i = 0; i < s.length(); i++){
            
            int len = sb.length();
            
            sb.append(s.charAt(i));
            
            helper(digits, map, sb, res, pos + 1);
            
            sb.setLength(len);
        }
        
    }
}
