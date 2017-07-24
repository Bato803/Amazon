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


这个Follow up是经典 number of distinct islands
比之前的明显要难些。 需要用到hashing得思想。 
每一个岛将遍历完的点id(每个cell 可以分配一个id, id = i*m+j) 组合起来， 返回字符串，比如 “1/2/3/5”  这个岛有四个点。如果另一个岛是 "11/12/13/15"  只要把它offset下， 第一位归1， 它也变成"1/2/3/5"， 
所以这2个岛的shape是一样的。 将这些第一位归1的字符串往set里丢。自然就除重了
中心思想： 将CELL ID组合来表示一个岛(hash to string)，然后变形string, 最后往set里丢。


