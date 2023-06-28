// https://leetcode.com/problems/find-the-town-judge

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in=new int[n+1];
        int[] out= new int[n+1];
        for(int[] arr:trust){
             out[arr[0]]++;
            in[arr[1]]++;
            
        }
        int ans=-1;
        for(int i=1;i<n+1;i++){
            if(in[i]==n-1){
                if(out[i]==0){
                    ans=i;
                }
            }
            
        }
        return ans;
        
        
    }
}