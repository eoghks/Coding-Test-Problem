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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode dummy = res;
        int prev = 0;
        while(l1 != null || l2 != null || prev != 0) {
            int sum = prev;
            if(l1 != null) {
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum+=l2.val;
                l2 = l2.next;
            }
            prev = sum /10;
            ListNode temp = new ListNode(sum%10);
            dummy.next = temp;
            dummy = dummy.next;
        }
        return res.next;
    }
}