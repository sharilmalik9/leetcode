// https://leetcode.com/problems/linked-list-cycle-ii

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
        if(head==null || head.next==null) return null;
        ListNode fast = head, slow = head;
        //lets find the cycle
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        if(slow!=fast) return null; //no cycle
        if(head==slow) return head; //cycle ended at the starting point only
        //lets find the starting point
        while(head!=slow){
            slow=slow.next;
            head=head.next;
            if(slow==head) return head;
        }
        return null;
    }
}