// https://leetcode.com/problems/merge-nodes-in-between-zeros

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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        ListNode new_head = new ListNode(0);
        ListNode z = new_head;
        while(temp!=null){
            
            if(temp.val==0){
                temp=temp.next;
                continue;
            }else{
                int sum=0;
                while(temp.val!=0){
                    sum=sum+temp.val;
                    temp=temp.next;
                }
                new_head.next= new ListNode(sum);
                new_head=new_head.next;
                continue;
            }
        }
        return z.next;
    }
}