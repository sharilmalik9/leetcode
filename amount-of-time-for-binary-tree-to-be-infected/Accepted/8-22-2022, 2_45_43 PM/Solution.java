// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected

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
    public void makeParent(TreeNode root, HashMap<TreeNode, TreeNode> parent){
        Queue<TreeNode> que= new LinkedList<>();
        que.add(root);
       while(que.size()!=0){
           TreeNode curr= que.poll();
           if(curr.left!=null){
               parent.put(curr.left,curr);
               que.add(curr.left);
           }
           if(curr.right!=null){
                parent.put(curr.right,curr);
               que.add(curr.right);
           }
       }
    }
    public TreeNode Find(TreeNode root, int start){
         
        if(root==null){
            return null; }
         if(root.val==start){
            return root;
        }
       
        TreeNode left=Find(root.left,start);
        TreeNode right=Find(root.right,start);
        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
            
        }
        return null;
        
            
        
        
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode ,TreeNode> parent = new HashMap<>();
        makeParent(root,parent);
       TreeNode find=Find(root,start);
         Map<TreeNode ,Boolean> visited = new HashMap<>();
        int time=-1;
        Queue<TreeNode> que= new LinkedList<>();
        que.add(find);
        visited.put(find,true);
        while(que.size()!=0){
            int sizey=que.size();
            time++;
            while(sizey!=0){
                TreeNode curr= que.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    que.add(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    que.add(curr.right);
                    visited.put(curr.right,true);
                }
                if(parent.get(curr)!=null && visited.get(parent.get(curr))==null){
                    que.add(parent.get(curr));
                    visited.put(parent.get(curr),true);
                }
                sizey--;
                System.out.println("heyyy");
            }
             System.out.println("hehehhe");
            
            
        }
        return time;
        
        
       
        
    }
}