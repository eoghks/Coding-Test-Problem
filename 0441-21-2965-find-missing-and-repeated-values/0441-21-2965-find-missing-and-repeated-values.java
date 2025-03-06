class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int size =  grid.length* grid.length;
        int[] freq = new int[size+1];
        
        for(int[] g: grid) {
            for(int i: g) {
                freq[i]++;
            }
        }

        int repeated = -1;
        int missing = -1;

        for(int i=1; i<=size; i++) {
            if(freq[i] == 0) {
                missing = i;
                if(repeated != -1)
                    break;
            } else if(freq[i] == 2) {
                repeated =i;
                if(missing != -1)
                    break;
            }
        }
        return new int[]{repeated, missing};
    }
}