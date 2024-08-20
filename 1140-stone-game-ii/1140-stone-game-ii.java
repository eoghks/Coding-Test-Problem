class Solution {
    int[] sum; //i번째부터 끝까지의 돌의 갯수
    int[][] temp; 
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        sum = new int[n];
        temp = new int[n][n];
        sum[n-1] = piles[n-1];
        for(int i = n-2; i>=0; i--) {
            sum[i] = sum[i+1] + piles[i];
        }
        
        return solution(piles, 0, 1);
    }
    public int solution(int[] piles, int i, int M) {
        if(2*M >= piles.length -i)
            return sum[i];
        if(temp[i][M] != 0)
            return temp[i][M];
            
        int min = Integer.MAX_VALUE; // 다음 플레이어가 가져갈수 있는 돌
        for(int j=1; j<=2*M; j++) {
            min = Math.min(min, solution(piles, i+j, Math.max(M,j)));
        }
        temp[i][M] = sum[i] - min; // 현재 가져갈수 있는 돌에서 다음 플레이어가 가져간돌을 제외한 수
        return temp[i][M];
    }
}