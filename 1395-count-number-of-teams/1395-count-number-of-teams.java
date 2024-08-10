class Solution {
    public int numTeams(int[] rating) {
        int cnt = 0;
        int[] small = new int[rating.length];
        int[] large = new int[rating.length];
        
        for(int i = 0; i < rating.length; i++) {
            for(int j = 0; j< i; j++) {
                if(rating[j] < rating[i])
                    large[i]++;
                else if(rating[j] > rating[i]) 
                    small[i]++;
            }
        }
        
        for(int i = 0; i < rating.length; i++) {
            for(int j = 0; j < i; j++) {
                if(rating[j] < rating[i])
                    cnt += large[j];
                else if(rating[j] > rating[i]) 
                    cnt += small[j];
            }
        }
        
        
        return cnt;
    }
}