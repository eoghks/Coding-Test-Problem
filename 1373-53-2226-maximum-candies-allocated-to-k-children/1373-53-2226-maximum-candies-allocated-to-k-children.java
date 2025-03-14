class Solution {
    public int maximumCandies(int[] candies, long k) {
        int res = 0;
        int left =1;
        int right = 10000000;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            long cnt = 0;

            for (int c : candies) {
                cnt += c / mid;
            }

            if (cnt >= k) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}