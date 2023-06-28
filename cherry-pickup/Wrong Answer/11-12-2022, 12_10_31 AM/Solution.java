// https://leetcode.com/problems/cherry-pickup

class Solution {
    public int cherryPickup(int[][] grid) {
        return help(0,0,0,grid);
        
    }
    public int help(int r1,int c1,int r2,int[][] arr){
        int c2=r1+c1-r2;
        if(c1>=arr[0].length || r1>=arr.length || c2>=arr[0].length || r2>=arr.length|| arr[r1][c1]==-1 || arr[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        if(r1==arr.length-1 && c1==arr[0].length-1){
            return arr[r1][c1];
        }
        
        int cherries=0;
        if(r1==r2 && c1==c2){
            cherries=arr[r1][c1];
            
        }
        else{
            cherries=arr[r1][c1]+arr[r2][c2];
        }
        int one=help(r1,c1+1,r2,arr);
        int two=help(r1+1,c1,r2,arr);
        int three=help(r1+1,c1,r2+1,arr);
        int four=help(r1,c1+1,r2+1,arr);
        cherries+=Math.max(one,Math.max(two,Math.max(three,four)));
        return cherries;
    }
}