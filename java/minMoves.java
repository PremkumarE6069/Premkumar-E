//minmove
import java.util.*;

public class minMoves {
    static ArrayList<String[][]> solutions = new ArrayList<>();

    private static boolean isSafe(String[][] mat, int r, int c) {
        for (int i = 0; i < r + 1; i++) {
            if (mat[i][c] == "Q") {
                return false;
            }
            if (r - i >= 0 && c - i >= 0 && mat[r - i][c - i] == "Q") {
                return false;
            }
            if (r - i >= 0 && c + i < mat.length && mat[r - i][c + i] == "Q") {
                return false;
            }
        }
        return true;
    }

    public static void nQueen(String[][] mat, int r) {
        if (r == mat.length) {
            String[][] temp = new String[mat.length][mat[0].length];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    temp[i][j] = mat[i][j];
                }
            }
            solutions.add(temp);
            return;
        }

        for (int i = 0; i < mat.length; i++) {
            if (isSafe(mat, r, i)) {
                mat[r][i] = "Q";
                nQueen(mat, r + 1);
                mat[r][i] = "–";
            }
        }
    }

    public static int minimumMoves(int N, String[][] A) {
        String[][] mat = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = "–";
            }
        }
        nQueen(mat, 0);
        int ans = Integer.MAX_VALUE;
        int[] pos = new int[N];
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (A[i][j] == "Q") {
                    pos[j] = i;
                    break;
                }
            }
        }
        for (String[][] x : solutions) {
            int[] temppos = new int[N];
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (x[i][j] == "Q") {
                        temppos[j] = i;
                        break;
                    }
                }
            }
            int tempans = 0;
            for (int i = 0; i < N; i++) {
                tempans += Math.abs(pos[i] - temppos[i]);
            }
            ans = Math.min(ans, tempans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 4;
        String[][] input = { { ".", "Q", ".", ".", }, { "Q", ".", ".", "Q", }, { ".", ".", ".", ".", },
                { ".", ".", "Q", "." } };
        int res = minimumMoves(N, input);

        System.out.println(res);
    }
}