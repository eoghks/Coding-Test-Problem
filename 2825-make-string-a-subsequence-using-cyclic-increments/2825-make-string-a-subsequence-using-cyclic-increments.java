class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int j = 0, n = str1.length(), m = str2.length();
        for (int i = 0; i < n && j < m; ++i) {
            int a = str1.charAt(i), b = str2.charAt(j);
            if (a == b || a + 1 == b || a - 25 == b)
                ++j;
        }
        return j == m;
    }
}