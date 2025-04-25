class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0)
            return true;
        int j = flowerbed.length;
        for(int i=0; i<j; i++) {
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i==j-1 || flowerbed[i+1] ==0)) {
                n--;
                flowerbed[i] =1;
                if(n==0)
                    return true;
            } 
        }
        return false;
    }
}