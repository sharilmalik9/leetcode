// https://leetcode.com/problems/maximum-width-of-binary-tree

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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> que= new LinkedList<>();
        root.val=1;
        int ans=1;
        que.add(root);
        while(que.size()!=0){
            int l=0;
            int r=0;
            int n=que.size();
            int curr=n;
            while(curr!=0){
                TreeNode nn=que.poll();
                if(curr==n){
                    l=nn.val;

                }
                if(curr==1){
                    r=nn.val;
                }
                if(nn.left!=null){
                    nn.left.val=nn.val*2;
                    que.add(nn.left);
                }
                if(nn.right!=null){
                    nn.right.val=nn.val*2+1;
                    que.add(nn.right);
                }
                ans=Math.max(ans,r-l+1);
                curr--;

            }
        }
        return ans;
        
    }
}