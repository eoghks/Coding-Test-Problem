/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<Node, Node>();
        
        Node dummy = new Node(0);
        Node newHead = dummy;
        
        while(head != null) {
            newHead.next = new Node(head.val);
            newHead = newHead.next;
            newHead.random = head.random;
            map.put(head, newHead);
            head = head.next;
        }
        
        newHead = dummy.next;
        while(newHead != null) {
            if(map.containsKey(newHead.random) == true) {
                newHead.random = map.get(newHead.random);
            }
            newHead = newHead.next;
        }
        return dummy.next;
    }
}