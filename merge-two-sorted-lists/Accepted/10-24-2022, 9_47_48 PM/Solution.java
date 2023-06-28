// https://leetcode.com/problems/merge-two-sorted-lists

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
        {
            return null;
        }
        if(list1 == null)
        {
            return list2;
        }
        if(list2 == null)
        {
            return list1;
        }
        ListNode list = new ListNode();
        ListNode res = new ListNode();
        res.next = list;
        while(list1 != null || list2 != null)
        {
            if(list1 == null)
            {
                ListNode node = new ListNode(list2.val);
                list.next = node;
                list = node;
                list2 = list2.next;
                continue;
            }
            else if(list2 == null)
            {
                ListNode node = new ListNode(list1.val);
                list.next = node;
                list = node;
                list1 = list1.next;
                continue;
            }
            
            if(list1.val < list2.val)
            {
                ListNode node = new ListNode(list1.val);
                list.next = node;
                list = node;
                list1 = list1.next;
            }
            else
            {
                ListNode node = new ListNode(list2.val);
                list.next = node;
                list = node;
                list2 = list2.next;
            }
        }
        res = res.next;
        return res.next;
    }
}