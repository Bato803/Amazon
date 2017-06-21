public class Solution {
    public int numIslands(char[][] grid) {
        
        
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(grid[i][j] == '1'){
                    
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
        
        
    }
    
    private void helper(char[][] grid, int i, int j){
        
        
        grid[i][j] = '0';
        
        int[] xs = new int[]{1, 0, -1,0};
        int[] ys = new int[]{0, 1, 0, -1};
        
        
        for(int k = 0; k < 4; k++){
            
            int x = i + xs[k];
            int y = j + ys[k];
            
            if(x >=0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1'){
                helper(grid, x, y);
            }

        }
    }
}
