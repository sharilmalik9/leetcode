// https://leetcode.com/problems/similar-string-groups

class Solution {
    public int numSimilarGroups(String[] strs) {
        int len=strs.length;
        int[]par=new int[len];
        int groups=len;
        for(int i=0;i<len;i++){
            par[i]=i;
        }
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                boolean similar=isSimilar(strs,i,j);
                if(similar){
                    int p1=findPar(par,i);
                    int p2=findPar(par,j);
                    if(p1!=p2){
                        par[p1]=p2;
                        groups--;
                    }
                }
            }
        }
        return groups;
    }
    public int findPar(int[]par,int u){
        return par[u]==u?u:(par[u]=findPar(par,par[u]));
    }
    public boolean isSimilar(String[]strs,int i,int j){
        int count=0;
        for(int k=0;k<strs[i].length();k++){
            char ch1=strs[i].charAt(k);
            char ch2=strs[j].charAt(k);
            if(ch1!=ch2){
                count++;
            }
            if(count>2){
                return false;
            }
        }
        return true;
    }
}