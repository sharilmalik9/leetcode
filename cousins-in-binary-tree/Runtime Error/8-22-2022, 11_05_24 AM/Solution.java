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
        if(root==null){
            return false;
        }
        Queue<TreeNode> que= new LinkedList<>();
        que.add(root);
        while(que.size()>0){
            int size=que.size();
            boolean isx=false;
            boolean isy=false;
            while(size>0){
                if(isx || isy){
                    TreeNode curr = que.poll();
                    //System.out.println(curr.val);
                    if(curr.left!=null){
                        if(curr.left.val==x ||curr.left.val==y){
                           return true; 
                         }
                        que.add(curr.left);
                         System.out.println(curr.left);

                    }
                    if(curr.right!=null){
                        if(curr.right.val==y|| curr.right.val==x){
                            return true;  
                        }
                        que.add(curr.right);
                                            System.out.println(curr.right);

                    } 
                }
                if(!(isx && isy)){
                     TreeNode curr= que.poll();
                   // System.out.println(curr.val);
                if(curr.left!=null){
                    if(curr.left.val==x ||curr.left.val==y){
                         if(curr.left.val==x){
                            isx=true;
                        }
                        else if(curr.left.val==y){
                            isy=true;
                        }
                    }
                    que.add(curr.left);
                    System.out.println(curr.left);

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
                    
                    que.add(curr.right);
                    System.out.println(curr.right);

                }
                  if(isx && isy){
                        return false;
                    }  
                    
                }
                
                size--;
}
            
        }
        return false;
    }
}