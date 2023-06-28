// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree

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

	class NodeValue{
		 int sum;
		 int minValue;
		 int maxValue;
	
		 NodeValue(int sum, int minValue, int maxValue){
			this.sum = sum;
			this.minValue = minValue;
			this.maxValue = maxValue;
		}
	
	}

	public int ansMax = Integer.MIN_VALUE;

    
    public int maxSumBST(TreeNode root) {
			//Math.max(ansMax,compute(root).sum);
			return compute(root).sum;
    }

	public NodeValue compute(TreeNode node){
		if(node == null) {
			return new NodeValue(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
		}
		
		NodeValue left = compute(node.left);
		NodeValue right = compute(node.right);

		if(node.val > left.maxValue && node.val < right.minValue){

			//ansMax = Math.max(Math.max(ansMax,left.sum + right.sum + node.val) , Math.max(left.sum,right.sum));

			return new NodeValue(
                Math.max(left.sum + right.sum + node.val,Math.max(left.sum,right.sum)),
				Math.min(left.minValue,node.val),
				Math.max(node.val, right.maxValue)
			);
		}

		return new NodeValue(
			Math.max(left.sum, right.sum),
			Integer.MIN_VALUE,
			Integer.MAX_VALUE
		);

}




}