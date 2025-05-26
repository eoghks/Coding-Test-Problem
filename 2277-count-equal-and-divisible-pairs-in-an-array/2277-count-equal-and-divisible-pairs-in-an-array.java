class Solution {
    public int countPairs(int[] nums, int k) {
        int pairs = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }
        
        List<Integer> divisors = new ArrayList<>();
        for (int d = 1; d * d <= k; d++) {
            if (k % d == 0) {
                divisors.add(d);
                if (d != k / d){
                    divisors.add(k / d);
                }
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int i : entry.getValue()) {
                int gcdd = gcd(i, k);
                int need = k / gcdd;
                pairs += temp.getOrDefault(need, 0);
                for (int d : divisors){
                    if (i % d == 0){
                        temp.put(d, temp.getOrDefault(d, 0) + 1);
                    }
                }
            }
        }
        return pairs;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}