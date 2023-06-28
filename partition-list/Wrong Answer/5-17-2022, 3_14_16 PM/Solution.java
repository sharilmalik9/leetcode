// https://leetcode.com/problems/partition-list

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
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode A=head;
         ListNode headA=null;
        while(A!=null){
            if(A.val<x){
                 headA=A;
               // System.out.println(headA.val);
                break;
            }
            A=A.next;
        }
        ListNode B= head;
         ListNode headB=null;
        while(B!=null){
            if(B.val>=x){
                 headB=B;
               // System.out.println(headB.val);
                break;
            }
            B=B.next;
        }
        ListNode safe=headA;
        ListNode safe1=headB;
        ListNode curr=head;
        while(curr!=null){
          //  System.out.println(curr.val);
           
            if(curr.val<x && curr!=headA){
                headA.next=curr;
               
                headA=headA.next;
            }
            else if(curr.val>=x && curr!=headB){
                    headB.next=curr;
                   
                    headB=headB.next;
            }   
            curr=curr.next;
        }
        if(headA!=null){
       headA.next=safe1;
            
        }
        else{
            return safe1;
        }
        if(headB!=null){
        
        headB.next= null;
        return safe;
        }
        return null;
       
        
    }
}