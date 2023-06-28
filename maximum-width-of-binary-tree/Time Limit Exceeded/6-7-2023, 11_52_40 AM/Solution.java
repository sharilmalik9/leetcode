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
        List<TreeNode> que=new ArrayList<>();
        int ans=1;
        que.add(root);
        while(que.size()!=0){
            int size=que.size();
            int hehe=check(que);
            if(hehe<=0){
                break;
            }
            ans=Math.max(ans,hehe);
            while(size!=0){
                TreeNode curr=que.remove(0);
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