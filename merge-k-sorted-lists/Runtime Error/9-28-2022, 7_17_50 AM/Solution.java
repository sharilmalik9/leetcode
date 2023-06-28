// https://leetcode.com/problems/merge-k-sorted-lists

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
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode curr:lists){
            while(curr!=null){
                pq.add(curr);
                curr=curr.next;
            }
        }
        ListNode head=pq.poll();
        ListNode make=head;
        while(pq.size()!=0){
            make.next=pq.poll();
            make=make.next;
            
            
        }
        make.next=null;
        return head;
        
        
    }
}