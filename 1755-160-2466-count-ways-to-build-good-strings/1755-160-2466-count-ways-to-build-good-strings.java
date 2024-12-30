class Solution {
    private int mod = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        if (zero > one) {
            return countGoodStrings(low, high, one, zero);
        }

        int[] dp = new int[high + 1];
        int res = 0;
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            // i>= zero의 의미는 zero는 최소 n개 부터 가능 하니 i가 zero보다 크거나 같아야 1개가 존재할수 있다.
            if (i >= zero)
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            // i>= one의 의미는 one는 최소 n개 부터 가능 하니 i가 one보다 크거나 같아야 1개가 존재할수 있다.
            if (i >= one)
                dp[i] = (dp[i] + dp[i - one]) % mod;
            if (i >= low)
                res = (res + dp[i]) % mod;
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}