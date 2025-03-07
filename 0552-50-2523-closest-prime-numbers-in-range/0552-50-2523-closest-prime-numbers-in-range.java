class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] primes = new boolean[right + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        //소수 구하기
        for (int i = 2; i * i <= right; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= right; j += i) {
                    primes[j] = false;
                }
            }
        }

        //범위에 맞는 소수 범위 구하기
        List<Integer> temp = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (primes[i]) {
                temp.add(i);
            }
        }

        int[] result = {-1, -1};
        if (temp.size() < 2) {
            return result;
        }

        int min  = Integer.MAX_VALUE;
         for (int i = 1; i < temp.size(); i++) {
            int cur = temp.get(i) - temp.get(i - 1);
            if (cur < min) {
                min = cur;
                result[0] = temp.get(i - 1);
                result[1] = temp.get(i);
            }
        }
        
        return result;
    }
}