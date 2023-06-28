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
    class pair{
        TreeNode node;
        int idx;
        public pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root){
        Queue<pair> que=new LinkedList<>();
        int ans=1;
        que.add(new pair(root,0));
        while(que.size()!=0){
            int size=que.size();
            int left=Integer.MAX_VALUE;
            int right=Integer.MIN_VALUE;
            while(size!=0){
                pair curr=que.poll();
                left=Math.min(curr.idx,left);
                right=Math.max(curr.idx,right);
                if(curr.node.left!=null){
                    que.add(new pair(curr.node.left,curr.idx*2+1));
                }
                if(curr.node.right!=null){
                    que.add(new pair(curr.node.right,curr.idx*2+2));
                }
                
                size--;
            }
            int width=right-left+1;
            ans=Math.max(width,ans);
        }
        return ans;
    }
}