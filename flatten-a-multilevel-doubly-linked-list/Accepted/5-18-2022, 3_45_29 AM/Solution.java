// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list

import java.util.*;
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
                                                                            

class Solution {
    public Node flatten(Node head) {
       if(head == null) return null;
        Node current = head;
        
        while(current != null){
            if(current.child == null) current = current.next;
            else{
                Node nextNode = current.next;
                Node childNode = current.child;
                
                current.child = null;
                current.next = childNode;
                childNode.prev = current;
                
                while(childNode.next != null) childNode = childNode.next;
                childNode.next = nextNode;
                
                if(nextNode != null) nextNode.prev =  childNode;
            }
        }
        return head;
        
        
    }
}