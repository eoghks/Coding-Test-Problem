class Solution {
    /*
    첫번째 로봇이 지나는 경우는 총 n가지이다.
    0번째, 1번째, 2번째..n-1번째에서 아래로 꺽은 경우
    그렇다면 각 경우에서 지나간 경로는 0으로 바뀌엇을 것이고, 
    두번째 로봇이 지나갈 것이다.
    최대의 값을 가지기 위해서 두번째 로봇이 지나갈 수 있는 방법은 2가지이다.
    첫번째 row와 두번째 row의 한방향을 0부터 n-1번째까지 가는것이다.
    */
    public long gridGame(int[][] grid) {
        long res = Long.MAX_VALUE;;

        long row1Sum = 0;
        for (int i = 0; i < grid[0].length; ++i) {
            row1Sum += grid[0][i];
        }

        long row2Sum = 0;
        for (int i = 0; i < grid[0].length; ++i) {
            row1Sum -= grid[0][i];
            res = Math.min(res, Math.max(row1Sum, row2Sum));
            row2Sum += grid[1][i];
        }
        return res;
    }
}