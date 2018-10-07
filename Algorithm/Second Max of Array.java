public class Solution {
    /**
     * @param nums: An integer array
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        // write your code here
        int firstLarge = Math.max(nums[0], nums[1]);
        int secondLarge = Math.min(nums[0], nums[1]);

        for (int i = 2 ; i < nums.length; i++) {
            if (nums[i] >= firstLarge) {
                secondLarge = firstLarge;
                firstLarge = nums[i];  
            }
            if (nums[i] > secondLarge && nums[i] < firstLarge) {
                secondLarge = nums[i];
            }
        }
        return secondLarge;
    }
}
