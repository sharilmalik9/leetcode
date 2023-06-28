// https://leetcode.com/problems/reverse-nodes-in-k-group

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
    int size;
    int grp=0;
    public ListNode reverseKGroup(ListNode head, int k) {
         size=size(head);
        return reverse(head,k);
       
        
        
    }
    public ListNode reverse(ListNode head,int k){
        if(head==null){
            return null;
        }
        grp++;
        ListNode next=null;
        ListNode prev=null;
        ListNode curr=head;
        int cnt=0;
        while(cnt<k && curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            cnt++;
            
            
        }
        if(next!=null && grp<=size/k){
            head.next=reverse(next,k);
        }
        else if(next!=null && grp>size/k){
            head.next=next;
        }
        return prev;
        
    } 
    public int size(ListNode head){
        int cnt=0;
        ListNode save=head;
        while(save!=null){
            cnt++;
            save=save.next;
            
        }
        return cnt;
    }
}