class Solution {
    public class Node implements Comparable<Node> {
        int key;
        int val;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        
        @Override
        public int compareTo(Node n) {
            if(this.val > n.val )
                return 1;
            else if(this.val < n.val)
                return -1;
            else if(this.val == n.val && this.key < n.key)
                return -1;
            else
                return 1;
        }
    }
    
    Map<Integer, Integer> dp = new HashMap<>();
    
    public int getKth(int lo, int hi, int k) {
        List<Node> list = new ArrayList<>();
        dp.put(1 ,0);
        for(int i = lo; i<=hi; i++) {
            list.add(new Node(i, solution(i)));
        }
        Collections.sort(list);
        
        return list.get(k-1).key;
    }
    
    public int solution(int n) {
        if(dp.containsKey(n) == false) {
            if(n%2 == 0)
                dp.put(n, solution(n/2)+1);
            else
                dp.put(n, solution(3*n+1)+1);
        }
        
        return dp.get(n);
    } 
}