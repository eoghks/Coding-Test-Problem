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
        /* Runtime 시간을 줄이는 코드(참고용)
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode preMid = slow;
        ListNode cur = slow.next;
        //한칸씩 중간에 끼워넣기
        while(cur.next != null){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = preMid.next;
            preMid.next = next;
        }
        
        ListNode p1 = head;
        ListNode p2 = preMid.next;
        
        while(p1 != preMid){
            preMid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMid.next;
        }
        */
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