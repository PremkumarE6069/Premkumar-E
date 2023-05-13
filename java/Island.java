//island
public class Island {
    public static void main(String[] args) {
        int[][] A = { { 1, 0, 0, 0 },
                { 1, 0, 0, 0 },
                { 0, 0, 1, 1 },
                { 1, 1, 1, 1 } };

        int res = minArea(A);
        System.out.println(res);
    }

    public static int minArea(int[][] A) {
        boolean[][] visited = new boolean[A.length][A[0].length];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (!visited[i][j] && A[i][j] == 1) {
                    int area = area(A, visited, i, j);
                    if (area < min)
                        min = area;

                    if (area > max)
                        max = area;
                }
            }
        }
        return max - min;
    }

    public static int area(int[][] A, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || visited[i][j] || A[i][j] == 0)
            return 0;

        visited[i][j] = true;
        int area = 1;

        // checking the neighbours
        area += area(A, visited, i - 1, j); // top
        area += area(A, visited, i + 1, j); // bottom
        area += area(A, visited, i, j - 1); // left
        area += area(A, visited, i, j + 1); // right

        return area;
    }
}