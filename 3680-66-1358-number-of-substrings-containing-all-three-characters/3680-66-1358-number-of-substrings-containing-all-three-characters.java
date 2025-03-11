class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int res = 0;
        int left = 0;
        int[] abc = new int[3];

        for(int right =0; right < n; right++) {
            abc[s.charAt(right) - 'a']++;
            while(abc[0] > 0 && abc[1] > 0 && abc[2] > 0) {
                res  += n-right;
                abc[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return res;
    }
}