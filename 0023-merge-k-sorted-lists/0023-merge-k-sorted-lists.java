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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a ,b) -> a.val-b.val);
        for(ListNode list : lists) {
            if(list != null) {
                pq.add(list);
            }
        }
        
        ListNode dummy = result;
        while(pq.isEmpty() == false) {
            dummy.next = pq.remove();
            dummy = dummy.next;
            if(dummy.next != null)
                pq.add(dummy.next);
        }
        
        return result.next;
    }
}