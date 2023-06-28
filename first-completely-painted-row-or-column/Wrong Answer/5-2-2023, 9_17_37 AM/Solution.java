// https://leetcode.com/problems/first-completely-painted-row-or-column

class Solution {
    class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer,pair> hm= new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                pair pp= new pair(i,j);
                hm.put(mat[i][j],pp);
            }
        }
        int n=mat.length;
        int m=mat[0].length;
        int[] rowtotal=new int[n];
        int[] coltotal=new int[m];
        for(int i=0;i<arr.length;i++){
            pair pp=hm.get(arr[i]);
            int x=pp.x;
            int y=pp.y;
            rowtotal[x]++;
            if(rowtotal[x]==n){
                return i;
            }
            coltotal[y]++;
            if(coltotal[y]==m){
                return i;
            }
        }
        return 0;
        


    }
}