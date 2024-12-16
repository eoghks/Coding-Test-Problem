class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]==b[1]? a[0]-b[0]: a[1]-b[1]));
        
        for(int i=0; i<nums.length; i++) {
            pq.add(new int[]{i, nums[i]});
        }
        
        while(k>0) {
            int[] temp = pq.poll();
            temp[1] = temp[1] * multiplier;
            pq.add(temp);
            k--;
        }

        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            nums[temp[0]] = temp[1];
        }
        
        return nums;
    }
}