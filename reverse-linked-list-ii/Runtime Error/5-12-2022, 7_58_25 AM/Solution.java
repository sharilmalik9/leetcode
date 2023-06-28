// https://leetcode.com/problems/reverse-linked-list-ii

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
    public ListNode reverseList(ListNode head,ListNode end){
        if(head!=null&& head.next!=null){
           ListNode prev=head;
          ListNode curr=head.next;
         while(curr!=end){
           ListNode after=curr.next;
           curr.next=prev;
           prev=curr;
           curr=after;
       }
        head.next=end;
        head=prev;
        
        return head;
        }
        else{
            return head;
        }
        
        
        
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(right==left){
            return head;
        }
        ListNode nn = head;
        ListNode tobegiven=head;
        ListNode ending=head;
        while(nn!=null){
        if(nn.val==left){
            tobegiven=nn;
            
            
        }
            if(nn.val==right){
                ending=nn.next;
                
            }
            nn=nn.next;
        }
        if(head.next==null){
            return head;
        }
        ListNode tochange=head;
        while(tochange!=null){
            if(tochange.next.val==left){
                break;
            }
            tochange=tochange.next;
        }
        ListNode newhead= reverseList(tobegiven,ending);
        tochange.next=newhead;
        
     return head; 
    }
}