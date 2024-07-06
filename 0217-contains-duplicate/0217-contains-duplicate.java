class Solution {
    public boolean containsDuplicate(int[] nums) {
        long size = IntStream.of(nums).distinct().count();
        if(size== nums.length)
            return false;
        return true;
    }
}