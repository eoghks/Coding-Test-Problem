class Solution {
    //solution1
    /*
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
    }*/
    
    //soultion2 ->binary search
    List<Integer> primes;
    public boolean primeSubOperation(int[] nums) {
        primes = getPrims(1000);
        int prev = 0;
        for(int n: nums) {
            if(prev >= n)
                return false;
            prev = n - search(n-prev);
        }
        return true;
    }
    
    private int search(int n) {
        int st = 0;
        int end = primes.size()-1;
        while(st < end) {
            int mid = (st + end)/2;
            if(n>primes.get(mid)) {
                st = mid+1;
            } else {
                end = mid-1;
            }
        }
        return primes.get(st) >=n? primes.get(st-1) : primes.get(st);
    }
    
    private List<Integer> getPrims(int num) {
        List<Integer> res = new ArrayList<>();
        boolean[] primes = new boolean[num+1];
        
        int i=2;
        res.add(0);
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