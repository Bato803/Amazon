public class Solution {
    public int maxProfit(int[] prices) {
        
        
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int res = 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int price : prices){
            
            if(price - min > res){
                res = price - min;
            }
            
            min = Math.min(price, min);
            
        }
        
        return res;
        
    }
}
