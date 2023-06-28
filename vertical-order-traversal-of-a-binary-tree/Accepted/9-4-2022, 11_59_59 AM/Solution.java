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
       }
        List<List<pair>> ls = new ArrayList<>();
        while(que.size()!=0){
            pair pp= que.poll();
            int y=pp.y;
            List<pair> curr = new ArrayList<>();
            PriorityQueue<pair> pnow= new PriorityQueue<>((a,b)->a.x-b.x);
            pnow.add(pp);
            while(que.size()!=0 && que.peek().y==y){
                pair now= que.poll();
                pnow.add(now);
            }
           
            while(pnow.size()!=0){
                 PriorityQueue<pair> haddhai=new PriorityQueue<>((a,b)->a.tp.val-b.tp.val);
                pair nn=pnow.poll();
                haddhai.add(nn);
                 while(pnow.size()!=0 && pnow.peek().x==nn.x){
                     haddhai.add(pnow.poll());
                     
}
                while(haddhai.size()!=0){
                    curr.add(haddhai.poll());
                }
                
               // haddhai.add(pnow.poll());
               
                
            }
            
           
            ls.add(curr);
            
        }
        System.out.println(ls);
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<ls.size();i++){
            List<Integer> curr= new ArrayList<>();
            for(int j=0;j<ls.get(i).size();j++){
                curr.add(ls.get(i).get(j).tp.val);
                
            }
            ans.add(curr);
        }
        return ans;
        
       
        
        
    }
}