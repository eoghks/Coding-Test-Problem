/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        PriorityQueue<ListNode> pq = new PriorityQueue<> (new Comparator<ListNode> () {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        
        while(head !=null){
            pq.add(head);
            head = head.next;
        }
        
        ListNode newHead = pq.poll();
        ListNode result = newHead;
        while(pq.isEmpty() == false) {
            newHead.next = pq.poll();
            newHead = newHead.next;
        }
        newHead.next =null;
        return result;
    }
}