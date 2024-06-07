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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(-1);
        ListNode prev = result;
        
        while(head != null) {
            if(prev.val > head.val) {
                prev = result;
            }
            
            while(prev.next != null && prev.next.val < head.val ) {
                prev = prev.next;
            }
            ListNode next = head.next;
            
            head.next = prev.next;
            prev.next = head;
            head = next;
        }
        return result.next;
    }
}