public class Solution {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    
    public Point globalOrigin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        
        globalOrigin = origin;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                int diff = getDistance(b, globalOrigin) - getDistance(a, globalOrigin);
                if(diff == 0) {
                    diff = b.x - a.x;
                }
                if (diff == 0) {
                    diff = b.y - a.y;
                }
                return diff;
            }
        });
        
        for (Point pt : points) {
            pq.add(pt);
            if (pq.size() > k){
                pq.poll();
            }
        }
        
        
        Point[] result = new Point[k];
        while (k - 1 >= 0) {
            result[--k] = pq.poll();
        }
        
        return result;
    }
    
    public int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y); 
    }
}






public class Solution {
    
    public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
        List<List<Integer>> results = new ArrayList<>();
        if (restaurant == null || restaurant.size() == 0 || n > restaurant.size()) {
            return results;
        }
        int[] disances = new int[restaurant.size()];
        for (int i = 0; i < restaurant.size(); i++) {
            disances[i] = getDistance(restaurant.get(i).get(0), restaurant.get(i).get(1));
        }
        Arrays.sort(disances);
        int max = disances[n - 1];
        for (int i = 0; i < restaurant.size(); i++) {
            if (getDistance(restaurant.get(i).get(0), restaurant.get(i).get(1)) <= max) {
                results.add(restaurant.get(i));
            }
        }
        return results;
    }

    public int getDistance(int x, int y) {
        return x * x + y * y;
    }
}






public class Solution {
    /**
     * @param restaurant:
     * @param n:
     * @return: nothing
     */
    public List<List<Integer>> nearestRestaurant(List<List<Integer>> restaurant, int n) {
        // Write your code here

        List<List<Integer>> res = new ArrayList<>();

        if (restaurant == null || restaurant.size() == 0 || n > restaurant.size()) {
            return res;
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> getDistance(o2) - getDistance(o1));


        for (List<Integer> list : restaurant) {

            pq.offer(new int[]{list.get(0), list.get(1)});

            if (pq.size() > n) {

                pq.poll();
            }
        }


        while (!pq.isEmpty()) {

            List<Integer> r = new ArrayList<>();


            int[] arr = pq.poll();

            if (arr != null) {

                r.add(arr[0]);
                r.add(arr[1]);
            }

            res.add(r);
        }
        Collections.reverse(res);

        return res;


    }


    public int getDistance(int[] arr) {
        return arr[0] * arr[0] + arr[1] * arr[1];
    }
}








