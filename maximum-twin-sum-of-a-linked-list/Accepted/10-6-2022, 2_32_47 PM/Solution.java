// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list

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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size(), max = Integer.MIN_VALUE;
        for(int i=0;i<size/2;i++) {
            max = Math.max(max, list.get(i) + list.get(size - i - 1));
        }
        return max;
    }
}