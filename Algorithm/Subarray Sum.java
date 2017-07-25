public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        
        if(nums == null || nums.length == 0){
            return res;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        map.put(0, 0);
        
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            
            if(map.containsKey(sum)){
                res.add(map.get(sum));
                res.add(i);
                break;
            }else{
                map.put(sum, i + 1);
            }
            
        }
        
        return res;
    }
}

public class GetSum {


    public static void main(String[] args) {


        int[] nums = new int[]{-1, 2, 3, 4, 5};


        System.out.println(Arrays.toString(getSum(nums, 8)));
    }

    private static int[] getSum(int[] nums, int target) {


        Map<Integer, Integer> map = new HashMap<>();


        int sum = 0;


        int[] res = new int[2];

        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];


            if (map.containsKey(sum - target)) {

                res[0] = map.get(sum - target);

                res[1] = i;
                break;
            } else {

                map.put(sum, i + 1);
            }


        }

        return res;
    }
}
