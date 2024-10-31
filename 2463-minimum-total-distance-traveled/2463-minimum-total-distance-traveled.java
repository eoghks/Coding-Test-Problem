class Solution {
    int n;
    int m;
    long[][] dp;
    List<Integer> f = new ArrayList<>();
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b) -> a[0] -b[0]);
        
        for(int[] fa: factory) {
            while(fa[1] > 0) {
                f.add(fa[0]);
                fa[1]--;
            }
        }
        
        n = robot.size();
        m = f.size();
        dp = new long[n][m];
        
        
        for(long[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        
        return solution(0, 0, robot);
    }
    
    private long solution(int i, int j, List<Integer> robot) {
        if(i == n)
            return 0;
        
        if(n-i > m-j)
            return Long.MAX_VALUE;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        long cost1 = Math.abs(f.get(j) - robot.get(i)) + solution(i+1, j+1, robot);
        long cost2 = solution(i, j+1, robot);
        
        dp[i][j] = Math.min(cost1, cost2);
        return dp[i][j];
        
    }
}