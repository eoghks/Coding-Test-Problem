class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int idx = 0;
        boolean isDesc = true;
        
        for(int i = len-1; i > 0; i--) {
            // 오름 차순이 끝나는 곳 파악
            if(nums[i] > nums[i-1]) {
                idx = i -1;
                isDesc = false;
                break;
            }
        }
        if(isDesc == true) {
            //내림 차순이라면 다음 행렬을 오름 차순이다.
            Arrays.sort(nums);
        } else if(idx == len -2) {
            //오름차순이 끝이 배열의 길이라면 마지막 두값만 바꿔주면됨
            int temp = nums[idx];
            nums[idx] = nums[idx + 1];
            nums[idx + 1] = temp;
        } else {
            int[] nums1 = Arrays.copyOfRange(nums, idx + 1, len);
            Arrays.sort(nums1);
            boolean ch = true;
            int val = nums[idx];
            System.out.println(val);
            for(int i =0; i < nums1.length; i ++) {
                if(ch == true && nums1[i] > val) {
                    System.out.println(nums1[i]);
                    nums[idx] = nums1[i];
                    nums[idx + 1 + i] = val;
                    ch = false;
                } else {
                    nums[idx + 1 + i] = nums1[i];
                }
            }
        }
    }
}