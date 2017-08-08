public class Solution {
    public int trap(int[] height) {
        
        if(height == null || height.length == 0){
            
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        
        int leftMax = 0;
        int rightMax = 0;
        
        
        int res = 0;
        
        while(left <= right){
            
            if(height[left] <= height[right]){
                
                if(leftMax <= height[left]){
                    leftMax = height[left];
                }else{
                    
                    res +=  leftMax - height[left] ;
                }
                
                left++;
            }else{

                if(rightMax <= height[right]){
                        
                     rightMax = height[right];
                }else{
                        
                    res += rightMax - height[right];
                }
                
                
                right--;
            }
            
            
        }
        
        return res;
    }
}


public class Solution {
    
    class Cell{
        
        int x;
        int y;
        
        int h;
        
        public Cell(int x, int y, int h){
            
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        
        
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0){
            
            return 0;
        }
        
        
        int m = heightMap.length;
        
        int n = heightMap[0].length;
        
        boolean[][] check = new boolean[m][n];
        
        
        PriorityQueue<Cell> q = new PriorityQueue(new Comparator<Cell>(){
            
            public int compare(Cell c1, Cell c2){
                
                return c1.h - c2.h;
            }
        });
        
        for(int i = 0; i < m; i++){
            
            
            check[i][0] = true;
            check[i][n - 1] = true;
            
            
            q.add(new Cell(i, 0, heightMap[i][0]));
            
            q.add(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        
        
        for(int i = 0; i < n; i++){
            
            check[0][i] = true;
            check[m - 1][i] = true;
            
            q.add(new Cell(0, i, heightMap[0][i]));
            
            q.add(new Cell(m - 1, i, heightMap[m - 1][i]));
            
        }
        
        
        int[] xs = new int[]{1, 0, -1, 0};
        int[] ys = new int[]{0, 1, 0 , -1};
        
        int res = 0;
        
        while(!q.isEmpty()){
            
            
            Cell cell = q.poll();
            
            for(int i = 0; i < 4; i++){
                
                int x = cell.x + xs[i];
                int y = cell.y + ys[i];
                
                
                if(x >= 0 && x < m && y >= 0 && y < n && !check[x][y]){
                    
                    q.add(new Cell(x, y, Math.max(cell.h , heightMap[x][y])));
                    
                    res += Math.max(0, cell.h - heightMap[x][y]);
                    
                    check[x][y] = true;
                }
            }
            
            
        }
        
        return res;
    }
}
