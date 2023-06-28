// https://leetcode.com/problems/flower-planting-with-no-adjacent

class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
         List<List<Integer>> adj = new ArrayList<>();
        int ans[] = new int[n];
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:paths){
            adj.get(p[0] - 1).add(p[1] - 1);
            adj.get(p[1] - 1).add(p[0] - 1);
        }
        for(int i=0;i<n;i++){
            boolean[] color= new boolean[5];
            for(int j:adj.get(i) ){
                color[ans[j]]=true;

            }
            for(int k=1;k<5;k++){
                if(!color[k]){
                    ans[i]=k;
                    break;
                }

            }
        }
        return ans;
        
    }
}