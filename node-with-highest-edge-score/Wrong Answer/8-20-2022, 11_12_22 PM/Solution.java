// https://leetcode.com/problems/node-with-highest-edge-score

class Solution {
    public int edgeScore(int[] edges) {
        int[] ans = new int[edges.length];
        for(int i=0;i<edges.length;i++){
            ans[edges[i]]=ans[edges[i]]+i;
            
}
        int max =0;
        System.out.println(Arrays.toString(ans));
        for(int i=0;i<ans.length;i++){
            if(ans[max]<ans[i]){
                max=i;
            }
            
            
        }
        return max;
    }
    
}