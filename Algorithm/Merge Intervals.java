
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        List<Interval> res = new ArrayList<>();
        
        if(intervals == null || intervals.size() == 0){
            return res;
        }
        
        
        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);
        
        
        Interval curr = intervals.get(0);
        
        for(int i = 1; i < intervals.size(); i++){
            
            Interval next = intervals.get(i);
            
            if(curr.end < next.start){
                res.add(curr);
                curr = next;
            }else{
                
                curr.end = Math.max(curr.end, next.end);
            }
            
        }
        
        res.add(curr);
        return res;
        
    }
}
