// https://leetcode.com/problems/symmetric-tree

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
     public int height(TreeNode root){
       if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
     public List<Integer> returnlevel(TreeNode root,int level,List<Integer> ans1){
        if(root== null){
          //  ans1.add(0);
            return null;
        }
       // List<Integer> ans1= new ArrayList<Integer>();
        if(level==1){
          //  System.out.println(root.val);
            ans1.add(root.val);
          //  System.out.println(ans1);
            
        }
        else if(level>1){
            if(root.left==null){
                ans1.add(Integer.MAX_VALUE);
                
            }
            
             returnlevel(root.left,level-1,ans1);
             if(root.right==null){
                ans1.add(Integer.MAX_VALUE);
            }
             returnlevel(root.right,level-1,ans1);
       
            
        }
      
        return ans1;
    }
    
    public boolean ispalin(List<Integer> ans){
        if(ans.size()==0){
            return true;
        }
        if(ans.size()==1){
            return true;
        }
        // int count=0;
        int count1=0;
        boolean palin = true;
        for(int i=0;i<ans.size()/2;i++){
          //  count++;
            if(ans.get(i)!=ans.get(ans.size()-i-1)){
               // System.out.println("here");
                // count1++;
                palin = false;
                break;
            } 
        }
         
        // if(count1==count){
        //     return true;
        // }
        // else{
        //     return false;
        // }
        return palin;
        
    }
    public boolean isSymmetric(TreeNode root) {
        int truecount=0;
        int falsecount=0;
        int count=0;
       
        
        for(int i=1;i<height(root)+1;i++){
            count++;
             List<Integer> ans1=new ArrayList<Integer>();
            
            ans1=returnlevel(root,i,ans1);
            System.out.println(ans1);
             System.out.println(ispalin(ans1));
            
           if(ispalin(ans1)){
               truecount++;
                
                
           }
           else{
               falsecount++;
            }
        }
        if(truecount==count){
            return true;
        }
        else{
            return false;
        }
        
        
        
    }
}