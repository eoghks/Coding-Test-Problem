class Solution {
    public long pickGifts(int[] gifts, int k) {
        long res = 0;
        int n = gifts.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        
        for(int i=0; i<n; i++) {
            pq.add(gifts[i]);
        }
        
        while(k>0){
            pq.add((int)Math.sqrt(pq.remove()));
            k--;
        }
        
        while(pq.size()>0){
            res+=pq.remove();
        }
        
        return res;
    }
}