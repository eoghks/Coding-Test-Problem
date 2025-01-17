class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        /* 방법 1
        int n=derived.length;
        int[] org=new int[n];
        
        //org 구하기
        for(int i=1; i<n; i++){
            org[i]=derived[i-1]^org[i-1];
        }

        //검증하기
        for(int i=0; i<n; i++){
            int idx=(i+1)%n;
            if(derived[i]!=(org[i]^org[idx])) 
                return false;
        }

        return true;
        */
        /* 방법 2
        derived[0] ^ derived[1] ^ ... ^ derived[3] = (org[0]^org[1]) ^ (org[1]^org[2]) ^ ... ^ (org[3]^org[0])
        (org[0]^org[1]) ^ (org[1]^org[2]) ^ ... ^ (org[3]^org[0]) = (org[0]^org[0]) ^ (org[1]^org[1]) ^ ... ^ (org[3]^org[3])
        (org[0]^org[0]) ^ (org[1]^org[1]) ^ ... ^ (org[3]^org[3]) = 0
        derived[0] ^ derived[1] ^ ... ^ derived[3] = 0
        */
        int xor = 0;
        for(int i=0; i<derived.length; i++) {
            xor^=derived[i];
        }
        return xor==0;
        
    }
}