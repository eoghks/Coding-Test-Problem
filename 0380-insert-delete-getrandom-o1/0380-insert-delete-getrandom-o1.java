class RandomizedSet {
    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val) == false) {
            map.put( val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.get(val);
            if (idx < list.size() - 1 ) { // not the last one than swap the last one with this val
                int last = list.get(list.size() - 1 );
                list.set( idx , last );
                map.put(last, idx);
            }
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
        
        return false;
    }
    
    public int getRandom() {
        return list.get( rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */