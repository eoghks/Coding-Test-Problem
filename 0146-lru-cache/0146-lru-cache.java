class LRUCache {
    private int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key) == true){
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }  
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key) == true) {
            cache.remove(key);
        }
        cache.put(key, value);
        if(capacity < cache.size()){
            int removeKey = cache.keySet().iterator().next();
            cache.remove(removeKey);
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */