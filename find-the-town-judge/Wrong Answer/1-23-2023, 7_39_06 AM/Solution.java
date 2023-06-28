// https://leetcode.com/problems/find-the-town-judge

class Solution {
    public int findJudge(int n, int[][] trust){
       int[] ls= new int[n+1];
        for(int[] i: trust){
            ls[i[0]]++;
        }
        int ans=-1;
        for(int i=1;i<n+1;i++){
            if(ls[i]==0){
                ans=i;
                break;
            }
        }
        return ans;
        
    }
}