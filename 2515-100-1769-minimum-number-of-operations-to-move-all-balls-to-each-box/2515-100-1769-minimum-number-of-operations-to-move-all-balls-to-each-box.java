class Solution {
    public int[] minOperations(String boxes) {
        //0 인덱스에 대한 값 구하기 + 왼쪽의 1 갯수, 오른쪽의 1 갯수 구하기
        int n = boxes.length();
        int[] res = new int[n];
        int left = boxes.charAt(0) == '1'? 1 : 0;
        int right = 0;
        for(int i=1; i<n; i++) {
            if(boxes.charAt(i) == '1') {
                right++;
                res[0] += i;
            }
        }     

        //i번째 인덱스는 i번째부터 n까지가 이동하는 1의 갯수가 줄어든 것이고,
        //0번째부터 i-1번째까지 잇는 이동하는 1의 갯수가 늘어난 것이다.
        //예시 2번의 index 4를 보면
        //index 3은 4이다. 4부터 5인덱스까지의 1의 갯수는 2개이니 -2, 0부터 3까지의 1의 갯수는 1개이니 +1
        //따라서 4-2+1 =3
        for(int i=1; i<n; i++) {
            res[i] = res[i-1] + left - right;
            if(boxes.charAt(i) == '1') {
                right --;
                left++;
            }
        }

        return res;
    }
}