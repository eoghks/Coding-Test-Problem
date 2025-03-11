class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int res = 0;
        int left = 0;
        int[] abc = new int[3];

        //substring의 시작 문자열의 index가 0~n-1까지
        //subString은 반드시 i번째 문자열이 포함된 경우로만 구하기
        for(int right =0; right < n; right++) {
            abc[s.charAt(right) - 'a']++;
            //abc의 수를 확인
            while(abc[0] > 0 && abc[1] > 0 && abc[2] > 0) {
                //길이가 n인 문자열이 존재할 때 시작 index 가 i인 subString의 수(i는 반드시 포함)
                //i, i~i+1, i~i+2, i~..n-1
                //이므로 n-i가 된다.
                res  += n-right;
                abc[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return res;
    }
}