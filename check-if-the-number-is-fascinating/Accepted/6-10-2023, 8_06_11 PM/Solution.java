// https://leetcode.com/problems/check-if-the-number-is-fascinating

class Solution {
    public boolean isFascinating(int n) {
        boolean[] vis=new boolean[10];
        int curr=n;
        while(n>0){
            vis[n%10]=true;
            n=n/10;
        }
        
        n=curr*2;
         while(n>0){
              if(vis[n%10] || n%10==0){
                 return false;
             }
             
            vis[n%10]=true;
            n=n/10;
        }
        n=curr*3;
        while(n>0){
            
             if(vis[n%10] || n%10==0){
                 return false;
             }
            vis[n%10]=true;
            n=n/10;
        }
        for(int i=1;i<=9;i++){
            if(vis[i]==false){
                return false;
            }
        }
        return true;
        
        
        
       
        
    }
}