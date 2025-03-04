class Solution {
    //3^x가 하나도 포함되지 않거나 1개만 포함되어야 한다.
    //만약 3개가 포함되면 이는 3^x*3이므로 3개가 포함된 경우는 생각할 필요가 없다.
    //이는 3으로 나누었을때 나머지가 2이면 안된다는 의미이다.
    public boolean checkPowersOfThree(int n) {
        while(n>0) {
            if(n%3==2)
                return false;
            n/=3;
        }
        return true;
    }
}