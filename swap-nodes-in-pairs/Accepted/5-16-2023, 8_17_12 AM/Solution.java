// https://leetcode.com/problems/swap-nodes-in-pairs

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
    public ListNode swapPairs(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode p=new ListNode(0);
        ListNode p1=head;
        ListNode p2=head.next;
        ListNode curr=p;
        while(p1!=null && p2!=null){
            curr.next=p2;
            ListNode t=p2.next;
            p2.next=p1;
            curr=p1;
            p1.next=t;
            p1=p1.next;
            if(t!=null){
                p2=t.next;
            }
        }
       
        return p.next;
        
    }
}