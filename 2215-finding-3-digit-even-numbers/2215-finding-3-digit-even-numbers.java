class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] digit = new int[10];
        List<Integer> res = new ArrayList<>();

        for (int d : digits){
            digit[d]++;
        } 
       
        for (int i = 1; i <= 9; i++) {
            if (digit[i] == 0){
                continue;
            } 
            digit[i]--;
            for (int j = 0; j <= 9; j++) {
                if (digit[j] == 0){
                     continue;
                }
                digit[j]--;
                for (int k = 0; k <= 8; k += 2) {
                    if (digit[k] == 0){
                         continue;
                    }
                    res.add(i*100 + j*10 + k);
                }
                digit[j]++;
            }
            digit[i]++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}