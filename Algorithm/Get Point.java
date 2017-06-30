public class GetPoint {


    public static void main(String[] args) {

        GetPoint getPoint = new GetPoint();


        int[][] nums = new int[][]{{5, 2, 3, 4, 5},
                {1, 5, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {5, 2, 3, 4, 5}};


        List<Point> res = getPoint.getPoint(nums);


        for (Point p : res) {

            System.out.println(p.x + "  " + p.y);
        }

    }


    class Point {
        int x;
        int y;

        int val;


        public Point(int x, int y, int val) {

            this.x = x;
            this.y = y;

            this.val = val;
        }


        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (obj instanceof Point) {
                Point other = (Point) obj;

                return this.x == other.x && this.y == other.y;
            } else {
                return false;
            }
        }

        public int hashCode(){
            return Integer.valueOf(x).hashCode() + Integer.valueOf(y).hashCode();
        }
    }


    private List<Point> getPoint(int[][] nums) {


        List<Point> res = new ArrayList<>();

        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return res;
        }


        int[] xs = new int[]{1, 0, -1, 0};
        int[] ys = new int[]{0, 1, 0, -1};


        int m = nums.length;
        int n = nums[0].length;


        Queue<Point> q = new LinkedList<>();


        q.add(new Point(0, 0, nums[0][0]));
        q.add(new Point(m - 1, 0, nums[m - 1][0]));
        q.add(new Point(0, n - 1, nums[0][n - 1]));
        q.add(new Point(m - 1, n - 1, nums[m - 1][n - 1]));


        Set<Point> set = new HashSet<>();

        set.add(new Point(0, 0, nums[0][0]));
        set.add(new Point(m - 1, 0, nums[m - 1][0]));
        set.add(new Point(0, n - 1, nums[0][n - 1]));
        set.add(new Point(m - 1, n - 1, nums[m - 1][n - 1]));


        while (!q.isEmpty()) {

            Point p = q.poll();

            int x = p.x;
            int y = p.y;


            for (int k = 0; k < 4; k++) {


                int i = x + xs[k];
                int j = y + ys[k];


                if (i >= 0 && i < m && j >= 0 && j < n) {


                    Point point = new Point(i, j, nums[i][j]);

                    if (!set.contains(point)) {
                        set.add(point);

                        if (nums[i][j] >= p.val) {

                            res.add(point);
                            q.add(point);
                        }

                    }
                }


            }
        }

        return res;


    }

}
