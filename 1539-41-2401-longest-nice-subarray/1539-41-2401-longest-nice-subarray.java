class Solution {
    //하위 배열의 두요소의 AND 연산은 0 => 같은 위치에 1Bit를 가지면 안된다.
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int max = 1;
        int left = 0;
        int bit = 0;

        for(int right = 0; right < n; right++) {
            while((bit & nums[right]) != 0) {
                bit ^= nums[left];
                left++;
            }

            //현재 요소를 포함한 Bit를 구하기 위해
            bit|=nums[right];
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}