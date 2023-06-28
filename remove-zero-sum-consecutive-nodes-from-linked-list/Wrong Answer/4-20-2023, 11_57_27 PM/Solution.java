// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list

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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(-1,head);
        HashMap<Integer,ListNode> hm= new HashMap<>();
        hm.put(0,dummy);
        hm.put(head.val,head);
        int sum=head.val;
        ListNode curr=head.next;
        while(curr!=null){
            sum+=curr.val;
            if(hm.containsKey(sum)){
                ListNode pul=hm.get(sum);
                ListNode sav=pul;
                ListNode up=curr.next;
                int delsum=sum;
                
                while(pul!=curr){
                    pul=pul.next;
                    delsum+=pul.val;
                    hm.remove(delsum);

                }
                sav.next=curr.next;
         
            }
            else{
                hm.put(sum,curr);
            
            }
             curr=curr.next;
        }
        return dummy.next;
    }
}