public class Solution {
    public int countPrimes(int n) {
        
        if(n == 0 || n == 1){
            return 0;
        }
        int count = 0;
        boolean[] check = new boolean[n];
        
        for(int i = 2; i < n; i++){
            
            
            int j = 1;
            
            
            if(check[i] == false){
                count++;
            }
            
            while(i * j < n){
                check[i * j] = true;
                j++;
            }
        }
        
        return count;
    }
}
