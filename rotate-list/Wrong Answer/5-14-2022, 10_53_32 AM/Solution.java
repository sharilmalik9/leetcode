// https://leetcode.com/problems/rotate-list

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
            
        }
        if(head.next==null){
            return head;
        }
        ListNode nn= head;
        int count =0;
        while(nn!=null){
            count++;
            nn=nn.next;
        }
        if(k==count){
           return reverseList(head);
            
            
        }
        if(k==0){
            return head;
        }
        ListNode curr=head;
        ListNode prev=head;
        ListNode secondlast=head;
       for(int i=1;i<count-k;i++){
           prev=prev.next;
       }
    secondlast=prev.next;
        while(curr.next!=null){
            curr=curr.next;
        }
        prev.next=null;
        curr.next=head;
        return secondlast;
        
        
    }
}