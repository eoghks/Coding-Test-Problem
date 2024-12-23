class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0] - a[0]));
        int[] res = new int[queries.length];
        int pos = 0;

        for(int q[] : queries) {
            if(q[0] == q[1] || (heights[Math.max(q[0], q[1])] > heights[Math.min(q[0], q[1])])){
                res[pos] = Math.max(q[0], q[1]);
                pos++;
                continue;
            }
            int temp[] = new int[3];
            temp[0] = Math.max(q[0], q[1]);
            temp[1] = Math.max(heights[q[0]], heights[q[1]]);
            temp[2] = pos; 
            pos++;
            pq.offer(temp);
        }
        
        TreeSet<int[]> set = new TreeSet<>((a,b)->(a[0] - b[0]));
        for(int i = heights.length - 1; i >= 0; i--) {
            while(pq.size() > 0 && pq.peek()[0] == i) {
                int q[] = pq.poll();
                int next[] = set.ceiling(new int[]{q[1] + 1,0});      
                if(next == null) 
                    res[q[2]] = -1;
                else {
                    res[q[2]] = next[1];
                }
            }
            while(set.size() > 0 && set.first()[0] <= heights[i]){
                set.remove(set.first());
            }
            int ele[] = new int[2];
            ele[0] = heights[i];
            ele[1] = i;
            set.add(ele);
        }
        
        
        return res;
    }
}