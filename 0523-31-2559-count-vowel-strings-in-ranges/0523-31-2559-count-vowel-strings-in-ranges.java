class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] dp = new int[words.length+1];
        for(int i=0; i<words.length; i++) {
            String s = words[i];
            dp[i+1] = dp[i];
            if(check(s.charAt(0)) && check(s.charAt(s.length()-1))) {
                dp[i+1]++;
            }
        }

        int[] res = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            res[i] = dp[queries[i][1]+1] - dp[queries[i][0]];
        }
        return res;
    }

    private boolean check(char c) {
        if(c =='a' || c =='e' || c=='i' || c=='o' || c=='u')
            return true;
        return false;
    }
}