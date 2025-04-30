class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
       for (int i : nums) {
            String s = Integer.toString(i);
            if (s.length() % 2 == 0)  {
                cnt++;
            }
        }
        return cnt;
    }
}