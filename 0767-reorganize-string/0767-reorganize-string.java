class Solution {
    public String reorganizeString(String s) {
        if(s.length() == 1) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            if(count > (s.length()+1) /2)
                return "";
            map.put(c, count);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.add(new int[] {c, map.get(c)});
        }
        
        while(pq.isEmpty() == false) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        
        return sb.toString();
    }
}