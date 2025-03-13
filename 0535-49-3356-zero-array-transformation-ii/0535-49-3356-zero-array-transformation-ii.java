class Solution {
    int n;
    public int minZeroArray(int[] nums, int[][] queries) {
        n = nums.length;

        if (Arrays.stream(nums).allMatch(x -> x == 0)) {
            return 0;
        }

        int left=1;
        int right = queries.length;
        if(canZero(right, nums, queries) == false) {
            return -1;
        }

        while(left<right) {
            int mid = left + (right-left)/2;
            if(canZero(mid, nums, queries))
                right = mid;
            else
                left = mid +1;
        }
        return left;
    }

    private boolean canZero(int k, int[] nums, int[][] queries) {
        int[] diff = new int[n+1];
        for(int i=0; i<k; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int val = queries[i][2];
            diff[left] += val;
            diff[right+1] -= val;
        }
        int cur = 0;
        for(int i=0; i<n; i++) {
            cur += diff[i];
            if(cur < nums[i])
                return false;
        }
        return true;
    }
}