// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree

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
        TreeNode tp;
        int x;
        int y;
        pair(TreeNode tp,int x,int y){
            this.tp=tp;
            this.x=x;
            this.y=y;
            
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<pair> pq= new LinkedList<>();
        PriorityQueue<pair> que= new PriorityQueue<>((a,b)->a.y-b.y);
        pq.add(new pair(root,0,0));
        while(pq.size()!=0){
            int size=pq.size();
            while(size!=0){
                pair curr=pq.poll();
                que.add(curr);
                
                
                if(curr.tp.left!=null){
                    pq.add(new pair(curr.tp.left,curr.x+1,curr.y-1));
                }
                if(curr.tp.right!=null){
                    pq.add(new pair(curr.tp.right,curr.x+1,curr.y+1));
                }
                size--;
                
                
}
            List<List<Integer>> ans= new ArrayList<>();
            

            
}
         List<List<Integer>> ans= new ArrayList<>();
        while(que.size()!=0){
            pair curr=que.poll();
            int y=curr.y;
            List<Integer> ls= new ArrayList<>();
            ls.add(curr.tp.val);
            while(que.size()!=0&&que.peek().y==y){
                ls.add(que.poll().tp.val);
                
            }
            Collections.sort(ls);
            ans.add(ls);
            
        }
        
            
        return ans;
        
        
    }
}