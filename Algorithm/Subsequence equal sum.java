public class Subsequence {


    public static void main(String[] args) {


        int[] arr = new int[]{6, 6, 12, 7 ,3};

        System.out.println(karmarkarKarpPartition(arr));


        System.out.println(getSubsequence(arr));
    }


    static List<List<Integer>> getSubsequence(int[] baseArr) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(baseArr.length, Collections.reverseOrder());

        for (int value : baseArr) {
            heap.add(value);
        }


        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        int sum1 = 0;
        int sum2 = 0;


        while (!heap.isEmpty()) {

            int num = heap.poll();

            if (sum1 < sum2) {

                sum1 += num;

                r1.add(num);
            } else {
                sum2 += num;
                r2.add(num);
            }

        }

        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>(r1));
        res.add(new ArrayList<>(r2));
        return res;
    }

    static int karmarkarKarpPartition(int[] baseArr) {
        // create max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(baseArr.length, Collections.reverseOrder());

        for (int value : baseArr) {
            heap.add(value);
        }


        while (heap.size() > 1) {
            int val1 = heap.poll();
            int val2 = heap.poll();
            heap.add(val1 - val2);
        }

        return heap.poll();
    }
}
