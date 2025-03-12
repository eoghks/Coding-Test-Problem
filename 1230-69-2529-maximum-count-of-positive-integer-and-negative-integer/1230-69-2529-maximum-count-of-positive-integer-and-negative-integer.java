class Solution {
    public int maximumCount(int[] nums) {
        int positive = 0;
        int negative = 0;
        for(int n: nums) {
            if(n<0) {
                negative++;
            } else if(n>0) {
                positive++;
            }
        }
        return Math.max(positive, negative);
    }
}