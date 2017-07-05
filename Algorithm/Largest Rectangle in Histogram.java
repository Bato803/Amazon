public class Solution {
    public int largestRectangleArea(int[] heights) {
        
        
        if(heights == null || heights.length == 0){
            
            return 0;
        }
        
        int n = heights.length;
        
        int[] h = new int[n + 1];
        
        for(int i = 0; i < n; i++){
            
            h[i] = heights[i];
        }
        
        
        Stack<Integer> stack = new Stack<>();
        
        
        int i = 0;
        
        int res = 0;
        
        while(i < h.length){
            
            if(stack.isEmpty() || h[i] >= h[stack.peek()]){
                
                stack.push(i);
                i++;
                
            }else{
                
                
                int pop = stack.pop();
                
                res = Math.max(res, (stack.isEmpty() ? i : i - stack.peek() - 1) * h[pop]);
                
            }
            
        }
        
        return res;
        
    }
}
