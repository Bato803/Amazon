public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        
        int[] res = new int[nums.length - k + 1];
        
        
        
        LinkedList<Integer> q = new LinkedList<>();
        
        
        for(int i = 0; i < nums.length; i++){
            
            if(!q.isEmpty() && i - k + 1 > q.peek()){
                
                q.poll();
            }
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                
                q.removeLast();
            }
            
            q.add(i);
            
            if(i - k + 1 >= 0){
                
                res[i - k + 1] = nums[q.peek()];
            }
            
        }
        
        return res;
    }
}



public class Solution {
    /**
     * @param nums: A list of integers.
     * @param k: An integer
     * @return: The maximum number inside the window at each moving.
     */
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        
        if(nums == null || nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        int[] res = new int[nums.length - k + 1];
        
        
        
        LinkedList<Integer> q = new LinkedList<>();
        
        
        for(int i = 0; i < nums.length; i++){
            
            if(!q.isEmpty() && i - k + 1 > q.peek()){
                
                q.poll();
            }
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                
                q.removeLast();
            }
            
            q.add(i);
            
            if(i - k + 1 >= 0){
                
                res[i - k + 1] = nums[q.peek()];
            }
            
        }
        
        
        List<Integer> list = new ArrayList<>();
        
        for(int num : res){
            
            list.add(num);
        }
        
        return list;
    }
}
