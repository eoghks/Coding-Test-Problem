class Solution {
    /*
    첫번째 로봇이 지나는 경우는 총 n가지이다.
    0번째, 1번째, 2번째..n-1번째에서 아래로 꺽은 경우
    그렇다면 각 경우에서 지나간 경로는 0으로 바뀌엇을 것이고, 
    두번째 로봇이 지나갈 것이다.
    
    최대의 값을 가지기 위해서 두번째 로봇이 지나갈 수 있는 방법은 2가지이다.
    첫번째 row와 두번째 row의 한방향을 0부터 n-1번째까지 가는것이다.
    참고로 이때 두번째 로봇은 최대 값을 수집하기 위해 간다!!
    
    그렇다면 여기서 첫번째 로봇이 두번째 로봇이 수집하는 포인트 수를 최소화 하려는 점을 고려하면,
    두번째 로봇이 지나갈 수 잇는 경우의 최소값이 된다.
    
    따라서, 생각할 수 있는것이 첫번째 로봇이 0~n-1번째 마다 아래로 꺽을 수 있고, 
    이에 따라서 두번째 로봇은 i번째에서 첫번째 로봇이 아래로 꺽은 경우 첫번째 row의 i ~ n-1의 합과 두번째 row 0~ i-1번째의 합의 최소값을
    모든 경우에 대하여 비교를하면 정답을 알 수 있다.

    즉, 각 경우에 대해 정리를 하면 첫번재 row의 합에서 0번째 index의 값을 뺀 값과 두번째 row는 0부터 시작하고 이를 비교하여 max 값을 구하고,
    다음 로직에서 첫번째 row의 합은 첫번째 row의 i번째 index의 값을 뺀 값과 두번째 row i-1번째 index의 값을 더한 두번째 row합의 max 값을 구해 이중 최소값을 구해야한다.
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