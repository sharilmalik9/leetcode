// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree

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
    List<Integer> nn=  new ArrayList<>();
    int cnt=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root);
        return cnt;
        
    }
    public boolean checkPalin(){
        System.out.println(nn);
        HashMap<Integer,Integer> hm= new HashMap<>();
        int n=nn.size();
        for(int i=0;i<n;i++){
            hm.put(nn.get(i),hm.getOrDefault(nn.get(i),0)+1);
            
        }
       List<Integer> values = new ArrayList(hm.values());
        boolean found=false;
        if(n%2==0){
            for(int i=0;i<values.size();i++){
                if(values.get(i)%2!=0){
                    return false;
                }
            }
        }
      
        else{
            for(int i=0;i<values.size();i++){
              if(values.get((i))%2!=0){
                  System.out.println(values.get((i)));
                  if(found){
                      return false;
                  }
                  else{
                      found=true;
                  }
              }
              
            }
            
            
        }

        return true;
        
    }
    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            nn.add(root.val);
            if(checkPalin()){
                cnt++;
            }
             nn.remove(nn.size()-1);
           
        }
        
        
         nn.add(root.val);
        if(root.left!=null){
             helper(root.left);
        }
       if(root.right!=null){
          helper(root.right);  
       }
        nn.remove(nn.size()-1);
       
        
    }
    
}