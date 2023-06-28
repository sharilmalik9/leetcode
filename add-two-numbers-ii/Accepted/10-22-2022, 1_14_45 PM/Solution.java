// https://leetcode.com/problems/add-two-numbers-ii

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
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head1 = rev(l1);
        ListNode head2 = rev(l2);
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int carry=0;
        
        while (head1 != null || head2 != null || carry >0) {
            int sum = 0;
            if (head1 != null) {
                sum += head1.val;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.val;
                head2 = head2.next;
            }
            sum=sum+carry;
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;
            carry=sum/10;
        }
        return rev(pre.next);
    }

    public ListNode rev(ListNode head){
        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode after=curr.next;
            curr.next=prev;

            prev=curr;
            curr=after;

        }
        return prev;
    }
}