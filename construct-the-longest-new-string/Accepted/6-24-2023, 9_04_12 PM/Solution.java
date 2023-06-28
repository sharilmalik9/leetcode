// https://leetcode.com/problems/construct-the-longest-new-string

class Solution {
    // 0 =x
    //1=y
    // 2=z
    Integer[][][][]  dp;
    public int longestString(int x, int y, int z) {
        dp=new Integer[x+1][y+1][z+1][4];
        return rec(x,y,z,-1);      
    }
    public int rec(int x,int y,int z,int prev){
        int ans=0;
        if(dp[x][y][z][prev+1]!=null){
            return dp[x][y][z][prev+1];
        }
       
            if(x>0 && prev!=0){
             ans=rec(x-1,y,z,0)+2;
        }
        
        if(prev!=0 && z>0){
            ans=Math.max(ans,rec(x,y,z-1,2)+2);
        }
        if(prev!=2 && y>0 && prev!=1){
            ans=Math.max(ans,rec(x,y-1,z,1)+2);
        }
        return dp[x][y][z][prev+1]=ans;
    }
}