class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int odd = 0;
        int even = 1;
        int result = 0;
        int sum = 0;
        for(int i: arr) {
            sum+=i;
            if(sum%2 == 1) {
                result = (result + even) % mod;
                odd++;
            } else {
                result = (result+ odd) % mod;
                even++;
            }
        }
        return result;
    }
}