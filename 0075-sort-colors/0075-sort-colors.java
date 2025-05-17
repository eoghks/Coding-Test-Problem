class Solution {
    /*count
    public void sortColors(int[] nums) {
        int count0 = 0; 
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {count0++;}
            if (nums[i] == 1) {count1++;}
            if (nums[i] == 2) {count2++;}
        }
        for(int i = 0; i < nums.length; i++) {
            if (i < count0) {nums[i] = 0;}
            else if (i < count0 + count1) {nums[i] = 1;}
            else {nums[i] = 2;}
        }
    }
    */
    /*change*/
     public void sortColors(int[] nums) {
        int idx =0;
        int p1 = 0;
        int p2 = nums.length-1;
        while (idx <= p2) {
            if (nums[idx] == 0) {
                nums[idx] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[idx] == 2) {
                nums[idx] = nums[p2];
                nums[p2] = 2;
                p2--;
                idx--;
            }
            idx++;
        }
    }
}