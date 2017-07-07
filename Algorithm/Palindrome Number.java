public class Solution {
    public boolean isPalindrome(int x) {
        
        if(x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        
        
        int res = 0;
        while(x > res){
            res = res * 10 + x % 10;
            x = x / 10;
        }
        
        return res == x || res / 10 == x;
        
    }
}


public class Palindrome {

    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();

        System.out.println(palindrome.isPalindrome(9));
    }


    public boolean isPalindrome(int i) {


        if (i < 0) {
            return false;
        }

        String s = Integer.toBinaryString(i);

        System.out.println(s);


        return isPalindrome(s);


    }


    private boolean isPalindrome(String s) {


        int st = 0;
        int ed = s.length() - 1;

        while (st <= ed) {

            if (s.charAt(st) != s.charAt(ed)) {
                return false;
            }

            st++;
            ed--;
        }

        return true;
    }


}
