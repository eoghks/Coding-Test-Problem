class Solution {
    public long pickGifts(int[] gifts, int k) {
        long res = 0;
        int n = gifts.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        
        for(int i=0; i<n; i++) {
            pq.add(gifts[i]);
        }
        
        //제일 많은 더미를 제곱근해서 다시 넣기
        while(k>0){
            pq.add((int)Math.sqrt(pq.remove()));
            k--;
        }
        
        //남은 선물의 합
        while(pq.size()>0){
            res+=pq.remove();
        }
        
        return res;
    }
}