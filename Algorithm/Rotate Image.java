public class Solution {
    public void rotate(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m / 2; i++){
            
            for(int j = 0; j < n; j++){
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - i][j];
                matrix[m - 1 - i][j] = temp;
            }
        }
        
        for(int i = 0; i < m; i++){
            
            for(int j = i + 1; j < n; j++){
                                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                
            }
        }
    }
}
