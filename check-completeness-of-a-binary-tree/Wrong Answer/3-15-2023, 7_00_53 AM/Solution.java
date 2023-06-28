// https://leetcode.com/problems/check-completeness-of-a-binary-tree

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
    public boolean isCompleteTree(TreeNode root) {
       Queue<TreeNode> que= new LinkedList<>();
       que.add(root);
       while(que.peek()!=null){
           int size=que.size();
         //  System.out.println(que);
           while(size!=0){
               TreeNode curr=que.poll();
                   if(curr==null && size!=1){
                       return false;
                   }
                   if(curr==null && size==1){
                       break;
                   }
                   que.add(curr.left);
                   que.add(curr.right);
                   size--;
               }
       }
       return true;
    }
}
// class Solution {
//     public boolean isCompleteTree(TreeNode root) {
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         queue.add(root);
//         while (queue.peek() != null) {
//             TreeNode node = queue.remove();
//             queue.add(node.left);
//             queue.add(node.right);
//         }
//         while (!queue.isEmpty() && queue.peek() == null)
//             queue.remove();
//         return queue.isEmpty();
//     }
// }