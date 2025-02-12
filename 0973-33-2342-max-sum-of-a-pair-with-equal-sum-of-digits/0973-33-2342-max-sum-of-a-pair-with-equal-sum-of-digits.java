class Solution {
    public int maximumSum(int[] nums) {
        int[] arr = new int[82];
        int res = -1; 
        for(int i=0; i<nums.length; i++) {
            int temp = nums[i];
            int sum = 0;

            while(temp>0) {
                sum += temp%10;
                temp = temp/10;
            }

            if(arr[sum] > 0) {
                res = Math.max(res, nums[i]+arr[sum]);
            }

            arr[sum] = Math.max(arr[sum], nums[i]);
        }
        return res;
    }
}