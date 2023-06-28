// https://leetcode.com/problems/beautiful-arrangement

class Solution {
    int[] ls;
    boolean[] vis;
    public int countArrangement(int n) {
        ls=new int[n+1];
        vis=new boolean[n+1];
        for(int i=1;i<=n;i++){
            ls[i]=i;
        }
        return rec(1,"");

    }
    public int rec(int idx,String curr){
        if(idx>=ls.length){
            System.out.println(curr);
            return 1;
        }
        int ans=0;
        for(int i=1;i<ls.length;i++){
            if((ls[i]%idx==0 || idx % ls[i]==0) && !vis[i] ){
                int sup=ls[i];
                vis[i]=true;
                ans+=rec(idx+1,curr+sup);
                vis[i]=false;
            }

        }
        return ans;
    }
}