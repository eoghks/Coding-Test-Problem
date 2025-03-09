class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int res = 0;
        int cur = 1;
        for (int i = 1; i <= n+k-2; i++) {
            if (colors[i % n] != colors[(i - 1 + n) % n]) {
                cur++;
            } else {
                cur = 1;
            }
            if (cur >= k) {
                res++;
            }
        }
        return res;
    }
}