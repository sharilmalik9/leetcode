// https://leetcode.com/problems/remove-nth-node-from-end-of-list

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
    
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nn = head;
        int length=0;
        while(nn!=null){
            length++;
            nn=nn.next;
        }
        if(head.next==null){
            return null;
        }
        ListNode nn1= head;
        
        
        if(n==1){
            for(int i=1;i<length-1;i++){
                nn1=nn1.next;
                
            }
            nn1.next=null;
            return head;
        }
        
        for(int i=1;i<length-1-n;i++){
            nn1=nn1.next;
            
        }
        
        nn1.next=nn1.next.next;
        return head; 
    }
}