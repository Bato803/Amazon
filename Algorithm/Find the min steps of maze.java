
class Node {

    private int x;
    private int y;

    private int step;


    Node(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}

public class ShortPath {


    public static void main(String[] args) {

        int[][] matrix = new int[][]
                {
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
                };
        ShortPath shortPath = new ShortPath();


        System.out.println(shortPath.getDistance(matrix, 3, 4));
    }


    public int getDistance(int[][] matrix, int x, int y) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return -1;
        }


        boolean[][] check = new boolean[m][n];


        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0, 0));
        check[0][0] = true;


        int[] xs = new int[]{1, 0, -1, 0};
        int[] ys = new int[]{0, -1, 0, 1};


        while (!q.isEmpty()) {

            Node temp = q.poll();


            int tempX = temp.getX();

            int tempY = temp.getY();


            if (tempX == x && tempY == y) {
                return temp.getStep();
            }


            for (int k = 0; k < 4; k++) {

                int i = tempX + xs[k];
                int j = tempY + ys[k];

                if (i >= 0 && i < m && j >= 0 && j < n && !check[i][j] && matrix[i][j] != 0) {

                    q.add(new Node(i, j, temp.getStep() + 1));

                    check[i][j] = true;
                }
            }


        }

        return -1;

    }
}
