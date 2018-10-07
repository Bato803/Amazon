/*
Description
Given an array, find two numbers in the array and their sum is closest to the target value but does not exceed the target value, return their sum.

if there is no result meet the requirement, return -1.

Have you met this question in a real interview?  
Example
Input:target = 15
array = [1,3,5,11,7]
Output:14

*/

public class Solution {
    /**
     * @param target: the target
     * @param array: an array
     * @return: the closest value
     */
    public int closestTargetValue(int target, int[] array) {
        // Write your code here
        
        
        
        int range = Integer.MAX_VALUE;
        int res = -1;
        
        for(int i = 0;  i < array.length; i++){
            
            
            for(int j = i + 1; j < array.length; j++){
                
                
                if((target - (array[i] + array[j]) >= 0) && (target - (array[i] + array[j]) < range)){
                   
                    
                    
                    res = array[i] + array[j];
                    
                    
                    range = target -  (array[i] + array[j]);
                }
            }
        }
        
        return res;
    }
}
