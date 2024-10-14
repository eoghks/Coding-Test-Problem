class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i: nums)
            pq.add(i);
        int i =0;
        while(i<k) {
            int n = pq.remove();
            sum+=n;
            pq.add((int)Math.ceil(n/3.0));
            i++;
        }
        
        return sum;
    }
}