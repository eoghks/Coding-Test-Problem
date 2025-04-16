class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int t = m*n;
        int[] arr = new int[t];
        
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        Arrays.sort(arr);
        int mid = t/2;
        int midVal = arr[mid];
        int cnt = 0;
        for(int val: arr){
            if(Math.abs(val-midVal)%x!=0) {
                return -1;
            }
            cnt += Math.abs(val-midVal)/x;
        }
        return cnt;
    }
}