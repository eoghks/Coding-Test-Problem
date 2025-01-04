class Solution {
    //Palindromic -> 앞에서부터 읽든 뒤에서 부터 읽든 같은 문자열
    public int countPalindromicSubsequence(String s) {
        //알파벳 수 만큼 해당 알파벳이 처음 나오는 부분과 마지막으로 나오는 부분을 기록
        int[][] arr = new int[26][2];
        char[] c = s.toCharArray();
        for(int[] a: arr) {
            Arrays.fill(a, -1);
        }
        for(int i=0; i<s.length(); i++) {
            int[] alp = arr[c[i]-'a'];
            if(alp[0] == -1)
                alp[0] = i;
            else
                alp[1] = i;
        }
        
        int res = 0;
        for(int i=0; i<arr.length; i++) {
            //0과1이 모두 나와야 똑같은 문자가 2번나온다는 의미 (앞뒤가 같은 알파벳이여야하므로)
            if(arr[i][0] != -1 && arr[i][1] != -1) {
                //중간 부분을 확인하는 중복을 방지하기 위해 set활용
                Set<Character> set = new HashSet<>();
                for(int j=arr[i][0]+1; j<arr[i][1]; j++) {
                    set.add(c[j]);
                }
                res+=set.size();
            }
        }
        return res;
    }
}