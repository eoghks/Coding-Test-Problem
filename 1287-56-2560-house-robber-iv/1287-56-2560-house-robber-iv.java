class Solution {
    //강도는 자기가 훔친 최대 금액의 밑에 금액만 훔칠 수 있다.
    //이때 k개의 집을 털 수 있는 경우 강도의 능력을 구하기
    public int minCapability(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (canStealKHouses(nums, k, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        
        return min;
    }

    private boolean canStealKHouses(int[] nums, int k, int mid) {
        int cnt = 0;
        int i = 0;
        while (i < nums.length) {
            //mid 보다 큰 경우는 훔칠수 없음
            if (nums[i] <= mid) {
                cnt++;
                i += 2;
            } else {
                i++;
            }
        }
        //k개를 훔칠 수 있는지 확인
        return cnt >= k;
    }

}