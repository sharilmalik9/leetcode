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
        if(head.next==null && head.val==0){
            return null;
        }
        int sum=0;
        ListNode curr=head;
        while(curr!=null){
            
            sum+=curr.val;
            if(hm.containsKey(sum)){
                ListNode pul=hm.get(sum);
                ListNode sav=pul;
                pul=pul.next;
                
                ListNode up=curr.next;
                int delsum=sum;
                
                while(pul!=curr){
                 
                    delsum+=pul.val;
                    hm.remove(delsum);
                       pul=pul.next;

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