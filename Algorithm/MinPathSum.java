package am;

import java.util.*;

public class MinPathSum {

    class Point {
        int x;
        int y;
        int val;

        Point(int x, int y, int val) {

            this.x = x;
            this.y = y;
            this.val = val;
        }
    }


    public int minPath(List<List<Integer>> grid, int val) {

        if (grid == null || grid.size() == 0 || grid.get(0).size() == 0) {

            return -1;
        }




        boolean[][] check = new boolean[grid.size()][grid.get(0).size()];
        Queue<Point> q = new LinkedList<>();

        Point point = new Point(0, 0, grid.get(0).get(0));


        q.offer(point);

        check[0][0] = true;

        int res = 0;

        int[] xs = new int[]{1, 0, -1, 0};
        int[] ys = new int[]{0, 1, 0, -1};

        while (!q.isEmpty()) {

            res++;

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Point p = q.poll();

                if (Objects.requireNonNull(p).val == val) {

                    return res;
                }



                for (int j = 0; j < 4; j++) {

                    int x = p.x + xs[j];
                    int y = p.y + ys[j];

                    if (x < 0 || x >= grid.size() || y < 0 || y >= grid.get(0).size() || check[x][y] || grid.get(x).get(y) == 0) {

                        continue;
                    }

                    q.offer(new Point(x, y, grid.get(x).get(y)));
                    check[x][y] = true;


                }
            }
        }

        return -1;
    }
}




public class Solution {
    /**
     * @param map: the map
     * @return: can you reach the endpoint
     */
    public boolean reachEndpoint(int[][] map) {
        // Write your code here


        if (map == null || map.length == 0 || map[0].length == 0) {


            return false;
        }

        int m = map.length;
        int n = map[0].length;


        Queue<int[]> q = new LinkedList<>();

        boolean[][] check = new boolean[m][n];


        check[0][0] = true;


        q.offer(new int[]{0, 0});

        int[] xs = new int[]{1, 0, -1, 0};

        int[] ys = new int[]{0 , 1, 0, -1};


        while (!q.isEmpty()) {


            int size = q.size();

            for(int i = 0; i < size; i++){


                int[] poll = q.poll();


                for(int j = 0; j < 4; j++){

                    if(poll != null) {

                        if(map[poll[0]][poll[1]] == 9){

                            return true;
                        }

                        int x = poll[0] + xs[j];
                        int y = poll[1] + ys[j];


                        if(x < 0 || x >= m || y < 0 || y >= n || check[x][y] || map[x][y] == 0){
                            
                            continue;
                        }
                        
                        check[x][y] = true;
                        q.offer(new int[]{x, y});

                    }
                }


            }

        }
        
        return false;


    }
}
