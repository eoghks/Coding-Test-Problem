class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int end = days[days.length-1];
        boolean[] travel = new boolean[end+1];
        for(int day: days)
            travel[day] = true;

        int[] dp = new int[end+1];
        dp[0] = 0;

        for(int i=1; i<=end; i++) {
            //여행을 하지 않았기 때문에 이전 비용과 동일
            if(travel[i] == false) {
                dp[i] = dp[i-1];
                continue;
            }

            //1일권 구매
            dp[i] = costs[0] + dp[i-1];
            //7일권 구매
            dp[i] = Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[i]);
            //30일권 구매
            dp[i] = Math.min(dp[Math.max(0, i - 30)] + costs[2], dp[i]);
        }

        return dp[end];
    }
}