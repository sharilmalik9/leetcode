// https://leetcode.com/problems/cousins-in-binary-tree

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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> que= new LinkedList<>();
        while(que.size()>0){
            int size=que.size();
            boolean isx=false;
                boolean isy=false;
            while(size>0){
                if(isx || isy){
                     TreeNode curr= que.poll();
                if(curr.left!=null){
                    if(curr.left.val==x ||curr.right.val==y){
                        return true;
                        
                        
                    }
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    if(curr.right.val==y|| curr.right.val==x){
                       
                      return true;  
                    }
                   
                    que.add(curr.right);
                }
               
                    
                }
                 if(!(isx && isy)){
                     TreeNode curr= que.poll();
                if(curr.left!=null){
                    if(curr.left.val==x ||curr.right.val==y){
                         if(curr.left.val==x){
                            isx=true;
                        }
                        else if(curr.left.val==y){
                            isy=true;
                        }
                        
                    }
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    if(curr.right.val==y|| curr.right.val==x){
                        if(curr.right.val==x){
                            isx=true;
                        }
                       else if(curr.right.val==y){
                            isy=true;
                        }
                       
                        
                    }
                    if(isx && isy){
                        return false;
                    }
                    que.add(curr.right);
                }
                
                    
                }
                    
                
                
                
                size++;
                
}
            
        }
        return false;
        
        
        
        
    }
}