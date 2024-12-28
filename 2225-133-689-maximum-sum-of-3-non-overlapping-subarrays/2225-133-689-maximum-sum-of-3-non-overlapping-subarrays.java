class Solution {
    //Key는 sbuArray의 합이 최대인 3가지를 구한다는것은 3요소의 합도 최대라는 의미이다. 
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length < k * 3)
            return new int[] {};
        //길이가 k인 subArray의 요소의 합 구하기
        int subLen = nums.length - k + 1;

        int[] subSum = new int[subLen];
        int sum = 0;

        for (int i = 0; i < k; i++)
            sum += nums[i];

        subSum[0] = sum;

        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            subSum[i - k + 1] = sum;
        }

        //왼쪽이 더큰 경우 각 요소마다 더 큰 합을 가지는 index가 어디인지 구하기
        int[] maxAtLeft = new int[subLen];

        for (int i = 1; i < subLen; i++)
            maxAtLeft[i] = subSum[i] > subSum[maxAtLeft[i - 1]] ? i : maxAtLeft[i - 1];

        //오른쪽이 더큰 경우 각 요소마다 더 큰 합을 가지는 index가 어디인지 구하기
        int[] maxAtRight = new int[subLen];
        maxAtRight[subLen - 1] = subLen - 1;

        for (int i = subLen - 2; i >= 0; i--)
            maxAtRight[i] = subSum[i] >= subSum[maxAtRight[i + 1]] ? i : maxAtRight[i + 1];

        //최종 연산
        int[] res = new int[3];
        int maxSum = 0;
        //i=k인 이유 앞에 합이 i=k여야 최소 i=0으로 잡히니 앞에 subArray의 요소가 존재한다.
        //subLne-k인 이유 i= subLen-k보다 작아야 최대 subLen인 index가 존재한다.
        for (int i = k; i < subLen - k; i++) {
            // 핵심: 3가지 max를 구하는 것이니 3요소의 합이 가장 큰 집합을 구해야한다.
            // 따라서 현재 index의 subArray 의 합과 왼쪽 오른쪽의 최대 index의 합을 구함
            // maxSum과 비교하여 가장 큰 subArray의 합을 구함
            int curSum = subSum[maxAtLeft[i - k]] + subSum[i] + subSum[maxAtRight[i + k]];
            if (curSum > maxSum) {
                maxSum = curSum;
                res = new int[] { maxAtLeft[i - k], i, maxAtRight[i + k] };
            }
        }
        return res;
    }
}