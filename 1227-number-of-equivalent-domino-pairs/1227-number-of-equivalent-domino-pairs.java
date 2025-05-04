class Solution {
    public int numEquivDominoPairs(int[][] d) {
        int[][] c = new int[9][9];
        int t = 0;

        for (int[] p : d) {
            int x = p[0] - 1, y = p[1] - 1;

            t += c[x][y];
            if (x != y) {
                c[x][y]++; 
                c[y][x]++;
            } else {
                c[x][x]++;
            }
        }
        return t;
    }
}