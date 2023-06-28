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
        TreeSet<pair> tm=new TreeSet<>((a,b)->
        a.y==b.y ? a.node.val-b.node.val : a.y-b.y);
        Queue<pair> que=new LinkedList<>();
        que.add(new pair(root,0,0));
        List<List<pair>> ans=new ArrayList<>();
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
        List<pair> ls=new ArrayList<>();
      
        for(pair curr:tm){
            if(ls.size()==0){
                ls.add(curr);
                continue;
            }
            if(curr.y==ls.get(ls.size()-1).y){
                ls.add(curr);
            }
            else{
                ans.add(ls);
                ls=new ArrayList<>();
                ls.add(curr);
            }

        }
        ans.add(ls);
        List<List<Integer>> hehe=new ArrayList<>();
        for(List<pair> ho: ans){
            List<Integer> help=new ArrayList<>();
            for(pair curr: ho){
                help.add(curr.node.val);
            }
            hehe.add(help);
        }
        return hehe;
    }

}