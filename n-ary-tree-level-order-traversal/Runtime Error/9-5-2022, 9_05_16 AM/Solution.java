// https://leetcode.com/problems/n-ary-tree-level-order-traversal

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
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> nn= new LinkedList<>();
        List<List<Integer>> ans= new LinkedList<>();
        nn.add(root);
        while(nn.size()!=0){
            List<Integer> curr= new ArrayList<>();
            int size=nn.size();
            while(size!=0){
                Node hey= nn.poll();
                curr.add(hey.val);
                for(Node now: hey.children){
                    nn.add(now);
                }
                size--;
            }
            ans.add(curr);
            
            
      
     
            
}
        return ans;
    }
}