class Solution {
    //dp1 114ms, 57.1MB
    /*
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
        
    }*/
    
    //dp2 35ms, 42.9MB
    int n;
    int m;
    long[][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b) -> a[0] -b[0]);

        n = robot.size();
        m = factory.length;
        dp = new long[n][m];

        return solution(0, 0, robot, factory);
    }
    
    public long solution(int i,int j, List<Integer> robot, int[][] factory) {
        if (i == n) {
            return 0;
        }

        if (j == m) {
            return Long.MAX_VALUE;
        }
        
        if(dp[i][j] != 0){
            return dp[i][j];
        }

        long res = solution(i, j + 1, robot, factory);

        long sum = 0;
        int cnt = 0;
        for (int k = i; k < n; k++) {
            int cur = Math.abs(robot.get(k) - factory[j][0]);
            if (cnt < factory[j][1]) {
                long next = solution(k + 1, j + 1, robot, factory);
                if(next!=Long.MAX_VALUE) {
                  next +=  sum + cur;
                }
                res = Math.min(res, next);
                cnt++;
                sum += cur;
            } else {
                break;
            }
        }
        return dp[i][j] = res;
    }
}