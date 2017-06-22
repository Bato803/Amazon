public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = m - 1;
        int j = 0;
        
        while(i >= 0 && j < n && matrix[i][j] != target){
            
            
            if(matrix[i][j] > target){
                i--;
            }else{
                j++;
            }
        }
        return i >= 0 && j < matrix[0].length && matrix[i][j] == target;
        
    }
}
