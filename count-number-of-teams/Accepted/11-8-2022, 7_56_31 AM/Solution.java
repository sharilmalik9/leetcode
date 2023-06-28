// https://leetcode.com/problems/count-number-of-teams

class Solution {
    public int numTeams(int[] rating){
       
        int ans=0;
        for(int i=0;i<rating.length;i++){
            int ls=0;
        int ll=0;
        int rs=0;
        int rl=0;
            
            for(int j=0;j<i;j++){
                if(rating[j]<rating[i]){
                    ls++;
                }
                else if(rating[j]>rating[i]){
                    ll++;
                }
            }
            for(int j=i+1;j<rating.length;j++){
                if(rating[j]<rating[i]){
                    rs++;
                }
                if(rating[j]>rating[i]){
                    rl++;
                }
            }
            ans+=ls*rl + ll*rs;
        }
        
        
        
        return ans;
        
        
    }
}