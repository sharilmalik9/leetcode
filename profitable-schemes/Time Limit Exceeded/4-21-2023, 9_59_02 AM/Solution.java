// https://leetcode.com/problems/profitable-schemes

class Solution {
    int mod = (int) (1e9 + 7);
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        return rec(group.length,minProfit,n,group,profit,0);



        
    }
    public int rec(int n ,int currprofit,int ppl,int[] group,int[] profit,int idx){
        if(idx==n){
           return currprofit==0 ? 1 : 0;
            
        }
        long p1=0;
        long p2=0;
        p1=rec(n,currprofit,ppl,group,profit,idx+1);
        if(ppl>=group[idx]){
            p2=rec(n,Math.max(currprofit-profit[idx],0),ppl-group[idx],group,profit,idx+1);
        }
        long p=p1+p2;
        p%=mod;
        return (int)p;
        

    }
}