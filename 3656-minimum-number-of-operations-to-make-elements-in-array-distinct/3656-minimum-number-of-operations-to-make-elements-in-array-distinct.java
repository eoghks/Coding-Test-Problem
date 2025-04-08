class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            //i/3은 자기전까지 몇번 지워졌는지
            //따라서 +1을 해서 자기 자신도 지워야한다.
            if(set.contains(nums[i])) {
                return i/3+1;
            }
            set.add(nums[i]);
        }
        return 0;
    }
}