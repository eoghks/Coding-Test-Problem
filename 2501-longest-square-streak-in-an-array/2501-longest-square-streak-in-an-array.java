class Solution {
    //use set
    /*
    public int longestSquareStreak(int[] nums) {
        int res = 0;
        Set<Long> set = new HashSet<>();
        for (int n : nums) {
            set.add(new Long(n));
        }
        
         for (int i = 0; i < nums.length; i++) {
            long n = nums[i];
            int len = 1;

            while (set.contains(n * n)) {
                System.out.println(n);
                System.out.println(n*n);
                n *= n;
                len++;
            }

            res = Math.max(res, len);
        }

        return res > 1? res : -1;
    }*/
    //use map
     public int longestSquareStreak(int[] nums) {
        int res=-1;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int a :nums){
            int sq = (int)Math.sqrt(a);
            if(sq*sq==a && map.containsKey(sq)){
                int cur = map.get(sq);
                map.put(a, ++cur);
                res=Math.max(res, cur);
            }
            else{
                map.put(a,1);
            }
        }
        return res;
        
    }
}