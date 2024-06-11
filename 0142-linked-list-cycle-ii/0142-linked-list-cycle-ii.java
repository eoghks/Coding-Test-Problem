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
        return result;
    }
}