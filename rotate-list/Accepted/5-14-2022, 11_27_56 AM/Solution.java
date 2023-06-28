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
    public ListNode rotate(ListNode head, int k,int count){
         
        
        if(k==count){
           return head;
            
            
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
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
            
        }
        if(head.next==null){
            return head;
        }
        
        
        int count =0;
        if(k==0){
            return head;
        }
        ListNode nn= head;
        while(nn!=null){
            count++;
            nn=nn.next;
        }
        ListNode newhead=head;
        if(k==count){
            return head;
        }
        if(k<count){
            return rotate(head,k,count);
        }
        int i= k-count;
        while(i>count){
            i=i-count;
        }
        
        return rotate(head,i,count);
        
        
        
    }
}