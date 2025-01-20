class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int res = -1;
        int m = mat.length;
        int n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        Map<Integer, int[]> map = new HashMap<>();
        //row별 count초기화
        Arrays.fill(row, n);
        Arrays.fill(col, m);

        //map init
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int[] pos = map.get(arr[i]);
            if (--row[pos[0]] == 0 || --col[pos[1]] == 0) {
                return i;
            }
        }
        return res;
    }
}