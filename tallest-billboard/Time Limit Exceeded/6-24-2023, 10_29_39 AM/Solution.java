// https://leetcode.com/problems/tallest-billboard

class Solution {
    public int tallestBillboard(int[] rods){
        int ans=rec(0,0,0,rods);
        return ans==-1 ? 0:ans;
        
    }
    public int rec(int idx,int sum1,int sum2,int[] rods){
        if(idx==rods.length){
            if(sum1==sum2 && sum1!=0){
                return sum1;
            }
            return -1;
        }
        int curr=-1;
        // not including 
        curr=Math.max(curr,rec(idx+1,sum1,sum2,rods));
        // include in one
        curr=Math.max(curr, rec(idx+1,sum1+rods[idx],sum2,rods));
        // include in two
        curr=Math.max(curr,rec(idx+1,sum1,sum2+rods[idx],rods));
       
        return curr;
    }
}