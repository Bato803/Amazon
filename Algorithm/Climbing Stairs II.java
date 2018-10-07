/*

Description
A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs.

Have you met this question in a real interview?  
Example
n=3
1+1+1=2+1=1+2=3=3

return 4

*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An Integer
     */
    public int climbStairs2(int n) {
        // write your code here
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int cur = 4, prev = 2, prevprev = 1;
        for (int i = 4; i <= n; i++) {
            cur = cur + prev + prevprev;
            prev = cur - prev - prevprev;
            prevprev = cur - prev - prevprev;
        }
        return cur;
    }
}
