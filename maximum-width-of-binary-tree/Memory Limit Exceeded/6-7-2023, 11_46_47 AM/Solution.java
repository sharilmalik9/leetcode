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
    public int widthOfBinaryTree(TreeNode root){
        Queue<TreeNode> que=new LinkedList<>();
        int ans=1;
        que.add(root);
        while(que.size()!=0){
            int size=que.size();
            List<TreeNode> ls=new ArrayList<>();
            while(size!=0){
                TreeNode curr=que.poll();
                ls.add(curr);
                if(curr==null){
                    que.add(null);
                    que.add(null);
                }
                else{
                    que.add(curr.left);
                    que.add(curr.right);
                }
                size--;
            }
            int hehe=check(ls);
            if(hehe<=0){
                break;
            }
             ans=Math.max(ans,hehe);
        }
        return ans;
    }
    public int check(List<TreeNode> ls){
       int  idx=0;
        while(idx<ls.size() && ls.get(idx)==null){
            idx++;
        }
        int back=ls.size()-1;
        while(back>=idx && ls.get(back)==null){
            back--;
        }

        return back-idx+1;

    }
}