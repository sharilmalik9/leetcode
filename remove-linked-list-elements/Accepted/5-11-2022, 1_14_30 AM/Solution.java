// https://leetcode.com/problems/remove-linked-list-elements

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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        while(head!=null&&head.next!=null && head.val==val){
            head=head.next;
        }
        if(head.next==null&&head.val==val){
            head=null;
        }
        if(head!=null && head.next!=null){
        ListNode prev=head;
        ListNode curr=head.next;
       
          
        
        while(curr!=null){
            
            
            if(curr.val==val){
                ListNode after= curr.next;
                prev.next=after;
                curr=after;
    
            }
            else{
                prev=curr;
                curr=curr.next;
                
            }
            
        }
            
            
            
        }
        return head;
        
        

    }
}