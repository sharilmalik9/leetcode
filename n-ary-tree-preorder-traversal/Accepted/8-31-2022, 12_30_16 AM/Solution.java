// https://leetcode.com/problems/n-ary-tree-preorder-traversal

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
    List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    void preorder(Node root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        for(int i = 0; i < root.children.size(); i++){  //accessing each child using a for loop
            preorder(root.children.get(i), list);
        }
    }
}