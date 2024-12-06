class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for(int e : banned){
            set.add(e);
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i))
                continue;
            if (i <= maxSum) {
                count++;
                maxSum -= i;
            } else {
                break;
            }
        }
        return count;
    }
}