// https://leetcode.com/problems/graph-connectivity-with-threshold

class Solution {
    int[] p;
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> ans= new ArrayList<>();
        p=new int[n+1];
        for(int i=0;i<n+1;i++){
            p[i]=i;
        }
        if(threshold==0){
            for(int i=0;i<queries.length;i++){
                ans.add(true);
            }
            return ans;
        }
        for(int i=threshold+1;i<n;i++){
            int j=2;
            while(i*j<n+1){
                union(i*j,i);
                j++;
            }
        }
        for(int[] query: queries){
            int px=parent(query[0]);
            int py= parent(query[1]);
            if(px==py){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }
    public void union(int x, int y){
        int px=parent(x);
        int py=parent(y);
        if(px==py){
            return;
        }
        p[px]=py;
    }
    public int parent(int x){
        if(p[x]==x){
            return x;
        }
        return parent(p[x]);
    }
}