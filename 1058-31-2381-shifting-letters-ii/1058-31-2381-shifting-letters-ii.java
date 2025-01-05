class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shift = new int[n];

        //이동하는 시작 및 끝 index 구하기
        for(int[] sh: shifts) {
            shift[sh[0]] += (sh[2] == 1? 1 : -1);
            if (sh[1] + 1 < n) 
                shift[sh[1] + 1] -= (sh[2] == 1 ? 1 : -1);
        }

        //각 index마다 움직일 거리 구하기
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            cur += shift[i];
            shift[i] = cur;
        }

        StringBuilder res = new StringBuilder(s);
        for(int i=0; i<n; i++) {
            //실제로 움직일 거리 구하기 (-를 +로변환)
            int sh = (shift[i] % 26 + 26) % 26;
            res.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + sh) % 26));
        }
        return res.toString();
    }
}