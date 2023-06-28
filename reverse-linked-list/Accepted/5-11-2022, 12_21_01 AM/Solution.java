// https://leetcode.com/problems/reverse-linked-list

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
    public ListNode reverseList(ListNode head){
        if(head!=null&& head.next!=null){
           ListNode prev=head;
          ListNode curr=head.next;
         while(curr!=null){
           ListNode after=curr.next;
           curr.next=prev;
           prev=curr;
           curr=after;
       }
        head.next=null;
        head=prev;
        
        return head;
        }
        else{
            return head;
        }
        
        
        
    }
}