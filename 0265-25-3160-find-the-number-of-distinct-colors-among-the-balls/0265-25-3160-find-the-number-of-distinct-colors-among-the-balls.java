class Solution {
    //ball의 색을 기억
    //color의 수를 기억
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ball = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();
        int n = queries.length;
        int[] res = new int[n];
        int colorCnt = 0;
        for (int i = 0; i < n; i++){
            int pos = queries[i][0];
            int c = queries[i][1];
            //이미 ball의 색이 칠해진 경우
            if(ball.containsKey(pos)) {
                int cnt = color.get(ball.get(pos)) -1;
                //색이 변경되어 색이 없는 경우 
                if(cnt == 0) {
                    color.remove(ball.get(pos));
                    colorCnt--;
                } else {
                    color.put(ball.get(pos), cnt);
                }
            }
            ball.put(pos, c);
            int cnt = color.getOrDefault(c, 0) + 1;
            color.put(c, cnt);
            //새로운 색이 추가된 경우
            if(cnt == 1)
                colorCnt++;
            res[i] = colorCnt;
        }
        return res;
    }
}