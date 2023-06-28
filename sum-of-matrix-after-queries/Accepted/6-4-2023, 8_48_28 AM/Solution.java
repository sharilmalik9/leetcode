// https://leetcode.com/problems/sum-of-matrix-after-queries

class Solution {
    public long matrixSumQueries(int n, int[][] q){
        HashSet<Integer> colhs=new HashSet<>();
        HashSet<Integer> rowhs=new HashSet<>();
       
        long ans=0;
        for(int i=q.length-1;i>=0;i--){
            if(q[i][0]==1){
                int col=q[i][1];
                int val=q[i][2];
                if(!colhs.contains(col)){
                    ans+=(n-rowhs.size())*val;
                    colhs.add(col);  
                }
            }
            else{
                int row=q[i][1];
                int val=q[i][2];
                if(!rowhs.contains(row)){
                    ans+=(n-colhs.size())*val;
                    rowhs.add(row);
                }
                
            }
        }
        return ans;
        
    }
}