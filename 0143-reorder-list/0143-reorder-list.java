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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        Deque<ListNode> deq = new ArrayDeque<ListNode>();
        ListNode dummy = head;
        while(dummy != null) {
            deq.add(dummy);
            dummy = dummy.next;
        }

        int len = (deq.size() - 1) / 2;
        dummy = head;
        for(int i =0; i < len; i++) {
            ListNode last = deq.pollLast();
            ListNode temp = dummy.next;
            dummy.next = last;
            last.next = temp;
            dummy = temp;
        }
       
        deq.pollLast().next = null;
    }

}