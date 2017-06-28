public class Solution {
    public int[][] generateMatrix(int n) {

        if(n == 0){
            return new int[0][0];
        }
        
        int[][] res = new int[n][n];
        
        int num = n * n;
        
        int i = 1;
        
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        
        while(i <= num){
            
            for(int j = colBegin; j <= colEnd; j++){
                res[rowBegin][j] = i++;
            }
            
            rowBegin++;
            
            
            for(int j = rowBegin; j <= rowEnd; j++){
                res[j][colEnd] = i++;
            }
            
            colEnd--;
            
            
            if(rowBegin <= rowEnd){
               
                for(int j = colEnd; j >= colBegin; j--){
                    res[rowEnd][j] = i++;
                }
                
            }
            
            rowEnd--;
            
            
            if(colBegin <= colEnd){
            
                for(int j = rowEnd; j >= rowBegin; j--){
                    res[j][colBegin] = i++;
                }
            }
                
            colBegin++;
        }
        
        return res;
    }
}
