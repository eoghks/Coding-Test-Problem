class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int res1 = 0;
        int res2 = 0;
        if(nums1.length%2 ==1) {
            for(int num: nums2) {
                res1^=num;
            }
        }
        if(nums2.length%2 ==1) {
            for(int num: nums1) {
                res2^=num;
            }
        }
        return res1^res2;
    }
}