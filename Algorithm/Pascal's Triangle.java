public class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        
        
        if(numRows == 0){
            
            return res;            
        }
        
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(new ArrayList<>(temp));
        
        List<Integer> prev = new ArrayList<>();
        
        for(int i = 2; i <= numRows; i++){
            
            List<Integer> r = new ArrayList<>();
            
            r.add(1);
            
            for (int j = prev.size() - 2; j >= 0; j--) {
                
                r.add(prev.get(j) + prev.get(j + 1));
            }
            
            r.add(1);
            
            prev = r;
            
            res.add(new ArrayList<>(r));
            
        }
        
        return res;
        
    }
}
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (rowIndex < 0)
            return result;

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }
}
