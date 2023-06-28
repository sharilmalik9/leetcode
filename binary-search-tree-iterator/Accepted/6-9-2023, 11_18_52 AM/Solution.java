// https://leetcode.com/problems/binary-search-tree-iterator

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        st.push(root);
        while(root.left!=null){
            st.add(root.left);
            root=root.left;
        }  
    }
    public int next(){
        TreeNode curr=st.pop();
        int ans=curr.val;
        if(curr.right==null){
            return curr.val;
        }
        st.push(curr.right);
        curr=curr.right;
        while(curr.left!=null){
            st.add(curr.left);
            curr=curr.left;
        }
        return ans;
    }
    
    public boolean hasNext() {
        if(st.size()==0){
            return false;
        }
        else{
            return true;
        }
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */