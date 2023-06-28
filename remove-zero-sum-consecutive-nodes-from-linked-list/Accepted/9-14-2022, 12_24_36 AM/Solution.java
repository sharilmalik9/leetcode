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
        
       ListNode dummy = new ListNode(0,head);   
        
       //Map that has key as the prefix sum and value as the node for that respective prefix sum
       Map<Integer, ListNode> map = new HashMap<>();
        
       int prefixSum = 0;
        
       //Put the dummy node as the value of key 0
       map.put(0, dummy);
        
       while(head != null){
           prefixSum += head.val;
           
           if(map.containsKey(prefixSum)){
               //From the map, remove entries of all nodes that we want to delete
			   ListNode prev = map.get(prefixSum);
               ListNode node = prev.next;
               int sum = prefixSum;
               
               while(node != head){
                   sum += node.val;
                   map.remove(sum);
                   node = node.next;
               }
               //Delete the nodes
               prev.next = head.next;
           } else{
               //If prefixSum does not already exist in map we can safely put the entry in map.
               map.put(prefixSum, head);
           }
           
           head = head.next;
       }
        
        return dummy.next;
       
     }
}