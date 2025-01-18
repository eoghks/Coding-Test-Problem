class Solution {
    int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int minCost(int[][] grid) {
        Deque<int[]> dque = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] minCost = new int[m][n];

        //init
        for(int i=0; i<m; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        dque.offerFirst(new int[]{0,0});
        minCost[0][0]=0;

        //logic
        while(!dque.isEmpty()){
            int[] arr=dque.pollFirst();
            int x=arr[0];
            int y=arr[1];

            //Visited adjacent cells
            for(int i=0; i<4; i++){
                int dx=x+dir[i][0];
                int dy=y+dir[i][1];
                int cost=(grid[x][y]!=(i+1))?1:0;

                //x좌표가 0이상  m보다 작음
                //y좌표가 0이상 n보다 작음
                //현재까지의 cost와 추가 cost가 이동하는 방향의 cost보다 적어야함
                //더 크다면 의미 없음
                if( dx>=0 && dx<m && dy>=0 && dy<n && minCost[x][y]+cost<minCost[dx][dy]){
                    minCost[dx][dy]=minCost[x][y]+cost;

                    if(cost==1){
                        dque.offerLast(new int[]{dx,dy});
                    }else{
                        dque.offerFirst(new int[]{dx,dy});
                    }                   
                }
            }
        }

        return minCost[m-1][n-1];
    }
}