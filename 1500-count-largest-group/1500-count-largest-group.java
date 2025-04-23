class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            int sum = digsum(i);
            map.put(sum, map.getOrDefault(sum, 0)+1);
            max = Math.max(max, map.get(sum));
        }
        for(int val: map.values()) {
            if(val == max) {
                cnt++;
            }
        }
        return cnt;
    }
    private int digsum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}