public class Solution {
    public String largestNumber(int[] nums) {
        
        
        if(nums == null || nums.length == 0){
            
            return "";
            
        }
        
        
        int n = nums.length;
        
        String[] res = new String[n];
        
        
        for(int i = 0; i < nums.length; i++){
            
            res[i] = String.valueOf(nums[i]);
            
            
        }
        
        Arrays.sort(res, new Comparator<String>(){
            
            public int compare(String s1, String s2){
                
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : res){
            
            sb.append(s);
        }
        
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
        
    }
}
