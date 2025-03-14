class Solution {
    //min과 max의 중간값을 가진 candy를 얼마나 나눠줄수 있는지 확인한다.
    public int maximumCandies(int[] candies, long k) {
        int res = 0;
        int min =1;
        int max = 10000000;

        while(min <= max) {
            int mid = min + (max - min) / 2;
            long cnt = 0;

            for (int c : candies) {
                cnt += c / mid;
            }

            if (cnt >= k) {
                res = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return res;
    }
}