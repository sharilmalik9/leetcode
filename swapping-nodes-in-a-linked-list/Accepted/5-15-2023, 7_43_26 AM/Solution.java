// https://leetcode.com/problems/swapping-nodes-in-a-linked-list

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode hh=head;
        int size=1;
        while(hh!=null){
            hh=hh.next;
            size++;
        }
        ListNode one=head;
        int m=1;
        while(m<k && one!=null){
            one=one.next;
            m++;

        }
        System.out.println(one.val);
        int n=1;
        ListNode two=head;
        while(n<size-k && two!=null){
            n++;
            two=two.next;
        }
        int temp=one.val;
        one.val=two.val;
        two.val=temp;
        return head;

    }
}