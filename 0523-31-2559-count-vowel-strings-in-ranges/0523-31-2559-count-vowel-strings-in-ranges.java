class Solution {
    //queries[i] = [li, ri] => 0에서부터 ri까지의 조건을 만족하는 요소 수 - 0에서부터 ri-1까지 조건을 만족하는 요소의 수
    public int[] vowelStrings(String[] words, int[][] queries) {
        //0에서부터 i-1까지 조건을 만족하는 요소 수
        int[] dp = new int[words.length+1];
        for(int i=0; i<words.length; i++) {
            String s = words[i];
            dp[i+1] = dp[i];
            if(check(s.charAt(0)) && check(s.charAt(s.length()-1))) {
                dp[i+1]++;
            }
        }

        //dp[i] = 0에서 부터 i-1까지 조건을 만족하는 요소 수
        int[] res = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            res[i] = dp[queries[i][1]+1] - dp[queries[i][0]];
        }
        return res;
    }

    //모음 확인
    private boolean check(char c) {
        if(c =='a' || c =='e' || c=='i' || c=='o' || c=='u')
            return true;
        return false;
    }
}