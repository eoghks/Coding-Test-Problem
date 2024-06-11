/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //플로이드 알고리즘
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast != slow) {
            return null;
        } 
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
        /*
        ListNode result = null;
        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null) {
            set.add(head);
            if(set.contains(head.next) == true){
                result = head.next;
                break;
            }
            head =head.next; 
        }
        return result;*/
    }
}