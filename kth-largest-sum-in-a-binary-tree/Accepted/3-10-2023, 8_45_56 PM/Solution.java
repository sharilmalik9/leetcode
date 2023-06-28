// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        long ans=0;
        q.offer(root);
        ArrayList<Long> sub=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            long sum=0;
            
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                sum+=node.val;
            }
            sub.add(sum);
        }
        Collections.sort(sub,Collections.reverseOrder());
        if(sub.size()>=k){
            ans=sub.get(k-1);
            return ans;
        }
        
        return -1;
    }
}