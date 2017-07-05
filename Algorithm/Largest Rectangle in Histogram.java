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


public class Solution {
    
    private int res = 0;
    
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        
        
        int[][] height = new int[matrix.length][matrix[0].length];
        
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = 0; j < matrix[0].length; j++){
                
                if(i == matrix.length - 1){
                    height[i][j] = matrix[i][j] == '1' ?  1 : 0;
                }else{
                    height[i][j] = matrix[i][j] == '1' ?  height[i + 1][j] + 1 : 0;
                }
                
                
                
            }
            
            getHeight(height[i]);
        }
        
        return res;
        
        
    }
    
    
    private void getHeight(int[] height){
        
        int[] h = new int[height.length + 1];
        
        
        for(int i = 0; i < height.length ; i++){
            h[i] = height[i];
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int i = 0;
        
        while (i < h.length) {

            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.add(i);
                i++;
            }else{
                int pop = stack.pop();
                res = Math.max(res, (stack.isEmpty() ? i : i - stack.peek() - 1) * h[pop]);
            }

        }
        
    }
}
