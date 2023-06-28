// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> que= new LinkedList<>();
        que.add(root);
        while(que.size()!=0){
            int size=que.size();
            
            while(size-1!=0){
                Node curr= que.poll();
                Node curr2=que.peek();
                curr.next=curr2;
                if(curr.left!=null){
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    que.add(curr.right);
                }
                size--;
                
                
                
                
                
            }
            Node hey=que.poll();
                hey.next=null;
            if(hey.left!=null){
                que.add(hey.left);
            }
            if(hey.right!=null){
                que.add(hey.right);
            }
            
}
        return root;
        
    }
}