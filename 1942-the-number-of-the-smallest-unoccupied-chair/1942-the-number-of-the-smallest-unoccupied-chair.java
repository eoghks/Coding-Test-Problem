class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        targetFriend = times[targetFriend][0];
        Arrays.sort(times, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> emptyChair = new PriorityQueue<>();
        int idx = 0;                                       
                                                      
        for(int[] time: times) {
            while(pq.isEmpty() == false && pq.peek()[0] <= time[0]) {
                emptyChair.add(pq.remove()[1]);
            }
            if(time[0] == targetFriend)
                break;
            int seat = emptyChair.isEmpty()? idx++: emptyChair.remove();
            pq.add(new int[]{time[1], seat});
            
        }
        return emptyChair.isEmpty()? idx: emptyChair.remove();
    }
}