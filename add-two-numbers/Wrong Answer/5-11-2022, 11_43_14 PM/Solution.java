// https://leetcode.com/problems/add-two-numbers

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head= new ListNode((l1.val+l2.val)%10);
        ListNode nn=head;
        int carry=(l1.val+l2.val)/10;
        if(l1.next==null && l2.next==null){
            return head;
        }
           
        
        if(l1.next!=null && l2.next!=null){
            l1=l1.next;
            l2=l2.next;
        
        
        while(l1!=null && l2!=null){

            int sum=l1.val+l2.val;
            
            ListNode cont=new ListNode(sum%10+carry);
             carry=sum/10;
            nn.next=cont;
            nn=nn.next;
            l1=l1.next;
            l2=l2.next;
        }
        }
        while(l1!=null){
            ListNode nn1= new ListNode((l1.val+carry)%10);
            carry= (l1.val+carry)/10;
            nn.next=nn1;
            nn=nn.next;
            l1=l1.next;
        }
        while(l2!=null){
            ListNode nn2= new ListNode((l2.val+carry)%10);
            carry=(l2.val+carry)/10;
            nn.next=nn2;
            nn=nn.next;
            l2=l2.next;
        }
        if(carry!=0){
            ListNode ele= new ListNode(carry);
            nn.next=ele;
        }
        
        return head;
        
        
    }
}