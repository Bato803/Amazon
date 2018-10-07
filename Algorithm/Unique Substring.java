/*
Description
Given a string s, find all the unique substring with the length of k and sort the results in lexicographic order.

Have you met this question in a real interview?  
Example
Input: s = "caaab"
k = 2
Output:["aa","ab","ca"]

*/

public class Solution {
    /**
     * @param s: a string
     * @param k: an integer
     * @return: all unique substring
     */
    public List<String> uniqueSubstring(String s, int k) {
        // Write your code here
        
        List<String> res = new ArrayList<>();


        if (s == null || s.length() == 0) {

            return res;
        }


        int st = 0;
        
        int ed = st + k;
        
        Set<String> set = new HashSet<>();
        
        while(ed <= s.length()){
            
            String temp = s.substring(st, ed);
            
            set.add(temp);
            
            ed++;
            st++;
        }
        
        res.addAll(set);
        
        Collections.sort(res);
        
        return res;
    }
}
