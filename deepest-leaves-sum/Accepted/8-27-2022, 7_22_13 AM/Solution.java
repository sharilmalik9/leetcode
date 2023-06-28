// https://leetcode.com/problems/deepest-leaves-sum

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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> que= new LinkedList<>();
        que.add(root);
        List<List<Integer>> ans= new ArrayList<>();
        while(que.size()>0){
            int size = que.size();
            List<Integer> pres= new ArrayList<>();
            while(size>0){
                TreeNode curr=que.poll();
                pres.add(curr.val);
                if(curr.left!=null){
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    que.add(curr.right);
                }
                size--;
                
}
            ans.add(pres);
            System.out.println(ans);
            
        }
        int ansf=0;
        for(Integer nn:ans.get(ans.size()-1)){
            ansf +=nn;
}
        return ansf;
        
    }
}