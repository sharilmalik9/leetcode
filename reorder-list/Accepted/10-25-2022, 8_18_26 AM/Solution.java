// https://leetcode.com/problems/reorder-list

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
    public void reorderList(ListNode head) {
        Queue<ListNode> q=new LinkedList<>();
        Stack<ListNode> s=new Stack<>();
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            q.add(temp);
            s.push(temp);
            temp=temp.next;
            count++;
        }
        temp=q.poll();
        count--;
        while(count>0){
            temp.next=s.pop();
            temp=temp.next;
            count--;
            if(count==0)
                break;
            temp.next=q.poll();
            temp=temp.next;
            count--;
        }
        temp.next=null;
    }
}