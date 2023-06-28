// https://leetcode.com/problems/average-of-levels-in-binary-tree

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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> que= new LinkedList<>();
        List<Double> ans= new ArrayList<>();
        que.add(root);
        que.add(null);
        Double sum=0.0;
        int cnt = 0;
        while(que.size()!=0){
                TreeNode curr=que.poll();
            if(curr == null){
                ans.add(sum/cnt);
                if(que.isEmpty()){
                    break;
                }
                que.add(null);
                cnt=0;
                sum = 0D;
                curr = que.poll();
            }
            
                sum+=curr.val;
                cnt++;
                
                if(curr.left!=null){
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    que.add(curr.right);
                }
        }
        return ans;
        
        
        
    }
}