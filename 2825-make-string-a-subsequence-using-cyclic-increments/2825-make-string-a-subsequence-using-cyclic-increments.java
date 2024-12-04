class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            int c1 = str1.charAt(i);
            int c2 = str2.charAt(j);
            if (c1 == c2 || c1 + 1 == c2 || c1 - 25 == c2)
                j++;
        }
        return j == m;
    }
}