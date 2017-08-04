public class Solution {
    public  int divide(int dividend, int divisor) {
        if (divisor == 0) return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long p = Math.abs((long) dividend);
        long q = Math.abs((long) divisor);

        int res = 0;

        while (p >= q) {
            int count = 0;

            while (p>= (q << count)) {
                count++;
            }

            res += 1 << (count - 1);
            p -= q << (count - 1);
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return res;
        else
            return -res;
    }
    
    
    
    /*
    
    multi
    
    */
    
    public int Mul(int a, int b) {
        int ans = 0;


        int count = 0;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans += a << count;
            }
            b = b >> 1;
            count++;
        }

        return ans;
    }
    
