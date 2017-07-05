/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        
        if(points == null || points.length == 0){
            return 0;
        }
        

        int count = 0;
        
        for(int i = 0; i < points.length; i++){
            int localMax = 0;            
            int duplicate = 1;
            Point first = points[i];
            
            int x1 = first.x;
            int y1 = first.y;
            
            Map<String, Integer> map = new HashMap<>();
            for(int j = i + 1; j < points.length; j++){
                
                Point sec = points[j];
                
                int x2 = sec.x;
                int y2 = sec.y;
                
                
                if(x1 == x2 && y1 == y2){
                    duplicate++;
                    continue;
                }
                
                
                String slope = getSlope(x2 - x1, y2 - y1);
                
                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
                
                localMax = Math.max(localMax, map.get(slope));
                
            }
            
            localMax = duplicate + localMax;
            
            count = Math.max(count, localMax);
            
        }
        
        return count;
        
    }
    
    private String getSlope(double x, double y){
        
        String sin = getSin(y, x);
        double gcd = gcd(y, x);
        
        
        return getSin(y, x) + Math.abs(y / gcd) + "/" + Math.abs(x / gcd);
    }
    
    private double gcd(double y, double x){
        
        if(x == 0){
            return y;
        }else{
            
            return gcd(x , y % x);
        }
    }
        
    
    
    private String getSin(double y, double x){
        
        return ((x >= 0 && y >= 0) || (x <= 0 && y <= 0)) ? "+" : "-";
    }
    
    
}
