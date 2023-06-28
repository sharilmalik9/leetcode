// https://leetcode.com/problems/odd-even-linked-list

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
    public ListNode oddEvenList(ListNode head) {
        ListNode head1= head;
        ListNode head2= head.next;
        ListNode final1=head2;
        ListNode head1s=head;;
        while(head1!=null&&head2!=null){
            if(head1.next!=null){
            head1.next=head1.next.next;
                head1s=head1;
                 head1=head1.next;
            }
            if(head2.next!=null){
            head2.next=head2.next.next;
                 head2=head2.next;
            }
           
        }
        if(head1==null){
        head1s.next=head2;
            head2.next=null;
        }
        else{
            head1.next=final1;
        }
        return head;
       
        
        
    }
}