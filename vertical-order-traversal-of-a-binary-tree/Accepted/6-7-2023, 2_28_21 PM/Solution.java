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
        TreeNode node;
        int x;
        int y;
        public pair(TreeNode node,int x,int y){
            this.node=node;
            this.x=x;
            this.y=y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root){
        PriorityQueue<pair> tm=new PriorityQueue<>((a,b)->{
        if(a.y==b.y){
            if(a.x==b.x){
                return a.node.val-b.node.val;
            }
            else{
                return a.x-b.x;
            }
        }
            return a.y-b.y;
        
        }
       );
        Queue<pair> que=new LinkedList<>();
        que.add(new pair(root,0,0));
        List<List<Integer>> ans=new ArrayList<>();
        while(que.size()!=0){
            pair pp=que.poll();
            tm.add(pp);
            if(pp.node.left!=null){
                que.add(new pair(pp.node.left,pp.x+1,pp.y-1));
            }
            if(pp.node.right!=null){
                 que.add(new pair(pp.node.right,pp.x+1,pp.y+1));

            }
        }
        while(!tm.isEmpty()){
            pair curr = tm.poll();
            int i = curr.y;
            List<Integer> arr = new ArrayList<>();
            arr.add(curr.node.val);
            while(!tm.isEmpty() && tm.peek().y == i){
                arr.add(tm.poll().node.val);
            }      
            ans.add(arr);      
        }
        return ans;
    }

}