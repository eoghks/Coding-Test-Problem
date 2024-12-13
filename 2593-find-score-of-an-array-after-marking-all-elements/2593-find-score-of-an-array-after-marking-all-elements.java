class Solution {
    public long findScore(int[] nums) {
        long res = 0;
        int n = nums.length;
        boolean[] mark = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        
        //init pq
        for (int i = 0; i < n; i++) {
            pq.add(new int[] {nums[i], i});
        }
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (!mark[cur[1]]) {
                mark[cur[1]] = true;
                res += cur[0];
                if (cur[1] - 1 >= 0) {
                    mark[cur[1] - 1] = true;
                }
                if (cur[1] + 1 < n) {
                    mark[cur[1] + 1] = true;
                }
            }
        }
        return res;
    }
}