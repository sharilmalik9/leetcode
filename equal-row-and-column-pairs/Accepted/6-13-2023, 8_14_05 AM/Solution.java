// https://leetcode.com/problems/equal-row-and-column-pairs

class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> mc=new HashMap<>(),mr=new HashMap<>();
        int n=grid.length,count=0;
        for(int i=0;i<n;i++){
            String s="";
            for(int j=0;j<n;j++)s+=(grid[i][j]+".");
            mc.put(s,mc.getOrDefault(s,0)+1);
        }
        for(int j=0;j<n;j++){
            String s="";
            for(int i=0;i<n;i++)s+=(grid[i][j]+".");
            mr.put(s,mr.getOrDefault(s,0)+1);
        }
        for(String s:mc.keySet())if(mr.containsKey(s))count+=(mc.get(s)*mr.get(s));
        return count;
    }
}