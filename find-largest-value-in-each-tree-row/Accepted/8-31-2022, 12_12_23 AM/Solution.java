// https://leetcode.com/problems/find-largest-value-in-each-tree-row

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
    public List<Integer> largestValues(TreeNode root) {
       
        Queue<TreeNode> que= new LinkedList<>();
        List<Integer> ans= new ArrayList<>();
         if(root==null){
            return ans;
        }
        que.add(root);
        while(que.size()!=0){
            int size= que.size();
            int max=Integer.MIN_VALUE;
            while(size!=0){
                TreeNode curr=que.poll();
                if(curr.val>max){
                    max=curr.val;
                }
                if(curr.left!=null){
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    que.add(curr.right);
                }
                size--;
                
            }
            ans.add(max);
        }
        return ans;
        
        
    }
}