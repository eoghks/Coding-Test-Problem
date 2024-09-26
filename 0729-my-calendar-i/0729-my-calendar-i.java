class MyCalendar {
    TreeMap<Integer, Integer> map = new TreeMap();
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        Integer smallerKey = map.floorKey(start);
        //smallerKey == null 
        //-> 내 행사보다 먼저 시작하는 행사가 없다. == 내 행사가 언제 시작하든 상관이 없다.
        //map.get(smallerKey) <= start 
        //-> 나보다 먼저 시작하는 행사 중 제일 마지막에 시작하는 행사가 내 행사 시작일보다 먼저 끝난다.
        if (smallerKey == null || map.get(smallerKey) <= start) {
            Integer greaterKey = map.ceilingKey(start);
            //greaterKey == null 
            //-> 내 행사보다 늦게 시작하는 행사가 없다. == 내 행사가 언제 끝나도 상관없다.
            //greaterKey >= end
            //-> 내 행사보다 늦게 시작하는 행사 중 제일 먼저 시작하는 행사의 시작일이 내 행사 끝나는 일보다 늦게 시작한다.
            if (greaterKey == null || greaterKey >= end) {
                map.put(start, end);
                return true;
            }
        } 
        return false;
            
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */