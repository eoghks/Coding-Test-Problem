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
        if(head == null || head.next == null || head.next.next == null)
            return;

        Deque<ListNode> deq = new ArrayDeque<ListNode>();
        ListNode dummy = head;
        while(dummy != null) {
            deq.add(dummy);
            dummy = dummy.next;
        }

        while(deq.isEmpty() == false) {
            ListNode front = deq.pollFirst();
            ListNode end = deq.pollLast();
            if(end != null) {
                reorder(front, end);
                dummy = end;
            } else
                dummy = front;
        }
        if(dummy != null) {
            dummy.next = null;
        }
        
        return;
    }
    
    public void reorder(ListNode front, ListNode end) {
        ListNode temp = front.next;
        front.next = end;
        end.next = temp;
    }
}