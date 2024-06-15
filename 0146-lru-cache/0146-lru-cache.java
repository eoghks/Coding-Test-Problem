//직접 구현
class LinkedNode {
  int key;
  int value;
  LinkedNode prev;
  LinkedNode next;
}

public class LRUCache {
    private HashMap<Integer, LinkedNode> cache = new HashMap<Integer, LinkedNode>();
    private int capacity;
    private LinkedNode head =  new LinkedNode();
    private LinkedNode tail = new LinkedNode();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    private void addNode(LinkedNode node) {
        node.prev = this.head;
        node.next = this.head.next;
        
        this.head.next.prev = node;
        this.head.next = node;
    }

    private void removeNode(LinkedNode node){
        LinkedNode prev = node.prev;
        LinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }


    private void moveToHead(LinkedNode node){
        //Node 삭제
        this.removeNode(node);
        //Head 다시 넣기
        this.addNode(node);
    }


    public int get(int key){
        if(this.cache.containsKey(key) == false)
            return -1;

        LinkedNode node = cache.get(key);
        this.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        if(this.cache.containsKey(key) == true) {
            LinkedNode node = cache.get(key);
            node.value = value;
            this.moveToHead(node);
        } else {
            LinkedNode newNode = new LinkedNode();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            if(this.cache.size() > capacity) {
                LinkedNode removeNode = this.tail.prev;
                this.removeNode(removeNode);
                this.cache.remove(removeNode.key);
            }
        }
    }
}

/*LinkedHashMap 활용
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
}*/


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */