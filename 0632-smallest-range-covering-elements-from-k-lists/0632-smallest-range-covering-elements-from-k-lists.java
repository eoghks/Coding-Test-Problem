class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        int resMin = 0;
        int resMax = 0;
        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.size(); i++) {
            int val = nums.get(i).get(0);
            Node n = new Node(val, 0, i);
            pq.add(n);
            curMax = Math.max(val, curMax);
        }
        
        while(pq.size() == nums.size()) {
            Node n = pq.remove();
            
            if(curMax - n.val < range) {
                range = curMax - n.val;
                resMin = n.val;
                resMax = curMax;
            }
            
            if(n.idx+1 < nums.get(n.row).size()) {
                n.idx++;
                n.val = nums.get(n.row).get(n.idx);
                pq.add(n);
                curMax = Math.max(curMax, n.val);
            }
        }
        
        return new int[]{resMin, resMax};
    }
    
    public class Node {
        int val;
        int idx;
        int row;
        
        public Node(int val, int idx, int row) {
            this.val = val;
            this.idx = idx;
            this.row = row;
        }
    }
}