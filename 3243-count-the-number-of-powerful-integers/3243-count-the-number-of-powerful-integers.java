class Solution {
    char[] suffixReq;
    int sLen;
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        suffixReq = s.toCharArray();
        sLen = suffixReq.length;
        return result(finish, limit) - result(start - 1, limit);
    }

    private long result(long num, int limit) {
        char[] range = Long.toString(num).toCharArray();
        int n = range.length;
        Long[][] dp = new Long[n][2];
        boolean checkIfSTrictThenPoss = false;
        if (isSmaller(range)){
            //뒤에 sLen 만큼의 자리수를 suffixReq와 비교
            checkIfSTrictThenPoss = isSmaller(Arrays.copyOfRange(range, (n - sLen) , n));
            return solve(0, 0, range, limit, n, dp, checkIfSTrictThenPoss);
        }
        return 0;
    }

    private boolean isSmaller(char[] range) {
        int n1 = range.length;
        if(n1 > sLen)
            return true;
        if(n1 < sLen)
            return false;
        for(int i=0; i<n1; i++) {
            if(range[i]>suffixReq[i]) {
                return true;
            }
            else if(range[i] < suffixReq[i]) {
                return false;
            }
        }
        return true;
    }

    //isStrict이 1인 경우는 0~i까지의 모든 자릿수가 finsih와 같은 경우를 의미
    private long solve(int i, int isStrict, char[] range, int limit, int n, Long[][] dp, boolean checkIfSTrictThenPoss){
        //자릿수가 finish와 같은 경우
        if (i == n){
            return 1;
        }
        if (dp[i][isStrict] != null){
            return dp[i][isStrict];
        }

        //i가 n-Slen과 같아진다는 것은 i 이후 자릿수는 SuffixReq와 같은 값이라는 의미이다.
        if (i == n - sLen) {
            //즉 checkIfSTrictThenPoss는 최대 숫자일 때 뒤에서 suffixReq보다 큰가?
            if (isStrict == 1) {
                return checkIfSTrictThenPoss ? 1 : 0;
            }
            return 1;
        }

        int till = limit;
        int num = (int) (range[i] - '0');
        if (isStrict == 1 || i == 0) 
            till = Math.min(limit, num);
        long ans = 0;

        for (int j = 0; j <= till; j++) {
            ans += solve(i + 1, (i == 0 ? (j == num ? 1 : 0) : isStrict) & (num == j ? 1 : 0), range, limit, n, dp, checkIfSTrictThenPoss);
        }
        return dp[i][isStrict] = ans;
    }
}