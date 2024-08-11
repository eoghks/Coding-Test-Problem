class Solution {
    Map<Integer, Integer> dp = new HashMap<>();
    
    public int getKth(int lo, int hi, int k) {
         PriorityQueue<int[]> pq 
             = new PriorityQueue<>((a,b)-> b[1]!=a[1] ?a[1]-b[1]:a[0]-b[0]);
        dp.put(1 , 0);
        for(int i = lo; i<=hi; i++) {
            pq.add(new int[]{i, solution(i)});
        }
        
        while(!pq.isEmpty() && k-- > 1)
            pq.poll();
        
        
        return pq.poll()[0];
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