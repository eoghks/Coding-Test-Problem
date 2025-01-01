class Solution {
    public int maxScore(String s) {
        char[] c = s.toCharArray();
        //왼쪽과 오른쪽 점수 초기화
        int left = c[0] == '0'? 1: 0;
        int right = 0;
        for(int i =1; i<c.length; i++) {
            if(c[i] == '1')
                right++;
        }

        int max = left+right;
        int cur = max;
        for(int i=1; i<c.length-1; i++) {
            //왼쪽으로 1을 옮길 경우 점수 -
            if(c[i] == '1') {
                right--;
            } else {
            //왼쪽으로 0을 옮길 경우 점수 +
                left++;
            }
            max = Math.max(left+right , max);
        }
        return max;
    }
}