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
            //계산이 필요한 애들만
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
            //set의 첫번째 요소가 height[i]보다 작으면 삭제하는 이유는
            //현재 i(왼쪽)에서 만나야하기 때문 
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