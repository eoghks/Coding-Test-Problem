class Solution {
    public boolean primeSubOperation(int[] nums) {
        List<Integer> primes = getPrims(1000);
        for(int i = nums.length-1; i>=1; i--) {
            if(nums[i-1] >= nums[i]) {
                int idx = -1;
                for(int j = 0; j < primes.size() && nums[i-1] > primes.get(j); j++) {
                    if(nums[i-1] - primes.get(j) < nums[i]) {
                        idx = j;
                        break;
                    }
                }
                
                if(idx == -1) {
                    return false;
                }
                nums[i-1] = nums[i-1] - primes.get(idx);
            }
        }
        return true;
    }
    
    private List<Integer> getPrims(int num) {
        List<Integer> res = new ArrayList<>();
        boolean[] primes = new boolean[num+1];
        
        int i=2;
        for(; i*i<=num; i++) {
            if(!primes[i]) {
                for(int j= i*2; j<=num; j=j+i) {
                    primes[j] = true;
                }
                 res.add(i);
            }
        }
        for(;i<=num;i++) {
            if(!primes[i])
                res.add(i);
        }
        return res;
    }
}