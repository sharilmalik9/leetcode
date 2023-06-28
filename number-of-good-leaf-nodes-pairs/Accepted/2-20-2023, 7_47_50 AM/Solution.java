// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs

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
    int goodpairs=0;
    int dist;
    public int countPairs(TreeNode root, int distance) {
        if(distance==1){
            return 0;
        }
        dist=distance;
        help(root);
        return goodpairs;

        
    }
    public List<Integer> help(TreeNode root){
        List<Integer> ls= new ArrayList<>();
        if(root==null){
            return ls;
        }
        if(root.left==null && root.right==null){
            ls.add(1);
            return ls;
        }
        List<Integer> left=help(root.left);
        List<Integer> right=help(root.right);
        for(int i=0;i<left.size();i++){
            for(int j=0;j<right.size();j++){
                if(left.get(i)+right.get(j)<=dist){
                    goodpairs++;
                }
            }
        }
        List<Integer> newl=new ArrayList<>();
        for(int i: left){
            if(i+1<dist){
                newl.add(i+1);
            }
        }
          for(int i: right){
            if(i+1<dist){
                newl.add(i+1);
            }
        }
        return newl;

    }
}