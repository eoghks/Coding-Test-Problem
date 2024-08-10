class Solution {
    public int numTeams(int[] rating) {
        int cnt = 0;
        int[] small = new int[rating.length];
        int[] large = new int[rating.length];
        
        for(int i=0; i<rating.length-1; i++) {
            for(int j=i+1; j<rating.length; j++) {
                if(rating[i] < rating[j])
                    small[i]++;
                else if(rating[i] > rating[j]) 
                    large[i]++;
            }
        }
        
        for(int i = 0; i < rating.length-1; i++) {
             for(int j=i+1; j<rating.length; j++) {
                if(rating[i] < rating[j])
                    cnt += small[j];
                else if(rating[i] > rating[j]) 
                    cnt += large[j];
            }
        }
        
        
        return cnt;
    }
}