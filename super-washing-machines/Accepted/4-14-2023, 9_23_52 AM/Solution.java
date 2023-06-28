// https://leetcode.com/problems/super-washing-machines

class Solution {
    public int findMinMoves(int[] machines) {
        int sum=0;
        for(int i:machines){
            sum+=i;
        }
        if(sum%machines.length!=0){
            return -1;
        }
        int avg=sum/machines.length;
        int ans=0;
        int cnt=0;
        for(int i: machines){
            cnt+=i-avg;
            ans=Math.max(ans,Math.max(i-avg,Math.abs(cnt)));
        }
        return ans;
    }
}