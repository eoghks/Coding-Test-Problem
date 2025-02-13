class Solution {
    public int minOperations(int[] nums, int k) {
        int cnt = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num: nums) {
            pq.add(new Long(num));
        }

        while(pq.peek() < k) {
            long x = pq.poll();
            long y = pq.poll();
            pq.add(Math.min(x,y) * 2 + Math.max(x,y));

            cnt++;
        }
        return cnt;
    }
}