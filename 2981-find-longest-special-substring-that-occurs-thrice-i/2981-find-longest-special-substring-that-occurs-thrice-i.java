class Solution {
    public int maximumLength(String s) {
        Map<Map.Entry<Character, Integer>, Integer> mps = new HashMap<>();
        int count;

        for (int i = 0; i < s.length(); i++) {
            count = 1;
            mps.put(Map.entry(s.charAt(i), count), mps.getOrDefault(Map.entry(s.charAt(i), count), 0) + 1);

            for (int j = i; j < s.length(); j++) {
                if (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                    mps.put(Map.entry(s.charAt(i), count), mps.getOrDefault(Map.entry(s.charAt(i), count), 0) + 1);
                } else {
                    break;
                }
            }
        }

        int ans1 = 0;
        for (Map.Entry<Map.Entry<Character, Integer>, Integer> x : mps.entrySet()) {
            if (x.getValue() >= 3) {
                ans1 = Math.max(x.getKey().getValue(), ans1);
            }
        }
        return (ans1 == 0) ? -1 : ans1;
    }
}