class Solution {
    //  Since the answer can be large, return it modulo 109 + 7.라고 문제에 나옴
    private int mod = (int) 1e9 + 7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        //for문에서 zero를 먼저 확인하기 때문에
        if (zero > one) {
            int temp = zero;
            zero = one;
            one = temp;
        }

        //중복에 대한 가능성 X -> 0은 zero에 따라 1은 one에 따라서만 append 가능하기 때문
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
        return res;
    }
}