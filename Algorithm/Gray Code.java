public class Solution {
    public List<Integer> grayCode(int n) {

        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < Math.pow(2, n); i++) {
            res.add(getCode(i));

        }

        return res;

    }

    public int getCode(int i) {
        return i^(i >> 1);
    }
}
