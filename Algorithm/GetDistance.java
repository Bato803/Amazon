given n pairs of numbers (1122...nn) and arrange them so that the each number x is x spaces apart from another number x. .

n == 4 : 42324311



public class GetDistance {

    String res;

    public static void main(String[] args) {


        GetDistance getDistance = new GetDistance();


        System.out.println(getDistance.getDistance(4));


    }


    private String getDistance(int n) {

        int[] visited = new int[n + 1];

        dfs("", 0, visited, n);


        return res;
    }


    private void dfs(String curr, int count, int[] visited, int n) {

        if (count == n * 2) {
            res = curr;
            return;
        }


        for (int i = 1; i <= n; i++) {

            if (visited[i] == 0) {
                visited[i]++;

                dfs(curr + i, count + 1, visited, n);

                visited[i]--;
            } else if (visited[i] == 1) {


                if (curr.length() - i >= 0 && curr.charAt(curr.length() - i) == '0' + i) {

                    visited[i]++;

                    dfs(curr + i, count + 1, visited, n);

                    visited[i]--;
                }
            }
        }
    }
}
