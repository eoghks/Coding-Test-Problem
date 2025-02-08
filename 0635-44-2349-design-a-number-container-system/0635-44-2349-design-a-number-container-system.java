class NumberContainers {
    //idx의 number를 저장
    Map<Integer, Integer> idx = new HashMap<>();
    //number를 가진 idx를 저장하는데 가장 낮은 idx를 구하기 위해 Priority Queue를 이용
    Map<Integer, PriorityQueue<Integer>> num = new HashMap<>();
    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        if(idx.containsKey(index)) {
            int prev = idx.get(index);
            if (prev == number) 
                return;
            num.get(prev).remove(index);
        }
        idx.put(index, number);

        if(!num.containsKey(number)) {
            num.put(number, new PriorityQueue<>());
        }
        PriorityQueue<Integer> curPq = num.get(number);
        curPq.offer(index);
    }
    
    public int find(int number) {
        if(num.containsKey(number)) {
            PriorityQueue<Integer> pq = num.get(number);
            if(!pq.isEmpty()) {
                return pq.peek();
            }
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */