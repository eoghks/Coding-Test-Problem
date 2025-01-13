class Solution {
    public int minimumLength(String s) {
        int[] alp = new int[26];
        int res =0;
        for(char c: s.toCharArray()) {
            alp[c-'a']++;
        }
        for(int a: alp) {
            if(a==0)
                continue;
            //짝수면 2 --> 3개이상일때 2개씩 지울수있으므로 2개가 될때까지 지울수있음
            //홀수면 1 --> 3개이상일때 2개씩 지울수있으므로 1개가 될때까지 지울수있음
            if(a%2==0) {
                res+=2;
            } else{
                res++;
            }
        }

        return res;
    }
}