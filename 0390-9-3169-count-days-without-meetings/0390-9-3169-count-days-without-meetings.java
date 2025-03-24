class Solution {
    public int countDays(int days, int[][] meetings) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(meetings, ((a,b)->a[0]-b[0]));

        for(int[] meeting: meetings) {
            int last = list.size()-1;
            if(list.isEmpty() || list.get(last)[1] < meeting[0]) {
                list.add(meeting);
            } else {
                list.get(last)[1] = Math.max(list.get(last)[1], meeting[1]);
            }
        }

        int sum = 0;
        for(int[] meeting: list) {
            sum += meeting[1]-meeting[0]+1;
        }

        return days- sum;
    }
}