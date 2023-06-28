// https://leetcode.com/problems/delete-nodes-and-return-forest

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
class Solution {
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans=new ArrayList<>();
        HashSet<Integer> hs= new HashSet<>();
        for(int i:to_delete){
            hs.add(i);
        }
        if(!hs.contains(root.val)){
           ans.add(root);
        }
        help(root,hs);
        return ans;

    }
    public TreeNode help(TreeNode root,HashSet<Integer> hs){
        if(root==null){
            return null;
        }
        root.left=help(root.left,hs);
        root.right=help(root.right,hs);
        if(hs.contains(root.val)){
            if(root.left!=null){
                ans.add(root.left);
            }
            if(root.right!=null){
                ans.add(root.right);
            }
            return null;
        }
        return root;
    }
}