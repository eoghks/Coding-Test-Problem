class Solution {
    //solution1
    /*
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
    }*/
    //solution2
    //nums의 길이가 작고 k가 작아서 해당 솔루션이 더 효율적
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int minValue = getMinValue(nums);
            int minIndexValue = getMinIndexValue(nums, minValue);
            nums[minIndexValue] = nums[minIndexValue] * multiplier;
        }
        return nums;
    }
    public int getMinValue(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            minValue = Math.min(minValue, nums[i]);
        }
        return minValue;
    }
    public int getMinIndexValue(int[] nums, int minValue) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minValue) {
                return i;
            }
        }
        return -1;
    }
}