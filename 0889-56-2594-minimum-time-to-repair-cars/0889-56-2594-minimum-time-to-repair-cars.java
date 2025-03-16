class Solution {
    public long repairCars(int[] ranks, int cars) {
        long min = 1;
        long max = (long)Arrays.stream(ranks).min().getAsInt() * cars * cars;

        while(min < max) {
            long mid = min + (max-min) / 2;
            if(canRepairAll(ranks, cars, mid)) {
                max = mid;
            } else {
                min = mid+1;
            }
        }

        return min;
    }

    private boolean canRepairAll(int[] ranks, int cars, long mid) {
        long total = 0;
        for(int rank: ranks) {
            total += Math.sqrt(mid/rank);
            if(total>=cars) 
                return true;
        }
        return false;
    }
}