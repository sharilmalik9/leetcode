// https://leetcode.com/problems/intersection-of-two-linked-lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        int count1=0;
        int count2=0;
        while(a!=null){
            count1++;
            a=a.next;
        }
        while(b!=null){
            count2++;
            b=b.next;
        }
        ListNode a1=headA;
        ListNode b1=headB;
        
    
        if(count1>count2){
            int difference= count1-count2;
            while(difference!=0){
                a1=a1.next;
                difference--;
                
            }
            
            
            
        }
        if(count2>count1){
            int difference1= count2-count1;
            while(difference1!=0){
                b1=b1.next;
                difference1--;
            }
            
            
        }
        while(a1!=null && b1!=null){
            if(a1.val==b1.val){
                return a1.next;
            }
            else{
                a1=a1.next;
                b1=b1.next;
            }
        }
        return null;
        
        
    }
}