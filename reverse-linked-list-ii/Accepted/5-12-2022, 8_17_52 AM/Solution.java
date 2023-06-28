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
        for(int i=2;i<=left;i++){
            tobegiven=tobegiven.next;
        }
        for(int i=1;i<=right;i++){
            ending=ending.next;
        }
        
        
        
        ListNode newhead= reverseList(tobegiven,ending);
        if(left==1){
            return newhead;
        }
        ListNode hey= head;
        
        for(int i=2;i<left;i++){
            hey=hey.next;
            
        }
        hey.next=newhead;
        
     return head; 
    }
}