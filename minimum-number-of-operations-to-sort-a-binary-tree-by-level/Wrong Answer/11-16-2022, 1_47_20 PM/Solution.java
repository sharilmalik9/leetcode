// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level

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
    public int minimumOperations(TreeNode root){
        List<Integer> ls=new ArrayList<>();
        int ans=0;
        Queue<TreeNode> que= new LinkedList<>();
        que.add(root);
        while(que.size()!=0){
            int size=que.size();
            while(size!=0){
                TreeNode curr=que.poll();
                ls.add(curr.val);
                System.out.println(curr.val);
                if(curr.left!=null){
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    que.add(curr.right);
                }
                size--;
            }
            System.out.println(ls);
            ans+=find(ls);
            ls= new ArrayList<>();
        }
        return ans;
        
        
        
    }
    public int find(List<Integer> ls){
        List<Integer> arr= new ArrayList<>(ls);
        Collections.sort(arr);
        int change=0;
        for(int i=0;i<arr.size();i++){
            if(ls.get(i)!=arr.get(i)){
                change++;
            }
        }
        return change%2==0 ? change/2 : change/2+1;
    }
}