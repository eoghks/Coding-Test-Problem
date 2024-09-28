class MyCircularDeque {
    int size;
    int max;
    Node head;
    Node tail;
    public MyCircularDeque(int k) {
        this.max = k;
        this.size = 0;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public boolean insertFront(int value) {
        if(isFull())
            return false;
        Node node = new Node(value);
        node.prev = head;
        head.next.prev = node;
        node.next= head.next;
        head.next = node;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
         if(isFull())
            return false;
        Node node = new Node(value);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty())
            return false;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty())
            return false;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty())
            return -1;
        return head.next.val;
    }
    
    public int getRear() {
        if(isEmpty())
            return -1;
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if(size == max)
            return true;
        return false;
    }
}

class Node {
    int val;
    Node next;
    Node prev;
    public Node(int val) {
        this.val = val;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */