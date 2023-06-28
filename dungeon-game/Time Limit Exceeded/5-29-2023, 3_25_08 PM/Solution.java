// https://leetcode.com/problems/dungeon-game

class Solution {
    int[][] dp;
    public int calculateMinimumHP(int[][] d) {
        dp= new int[d.length][d[0].length];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return 1+rec(d,0,0,0);
    }
    public int rec(int[][] d,int i,int j,int pos){
       
        if(i==d.length-1 && j==d[0].length-1){
            if(d[i][j]<0 && pos<Math.abs(d[i][j])){
                System.out.println(Math.abs(d[i][j])-pos);
              return  Math.abs(d[i][j])-pos;
            }
          //
          
           // System.out.println(i+" "+j+ " "+pos);
            return 0;
        }
        if(i>=d.length || j>=d[0].length){
            return Integer.MAX_VALUE;
        }
        int ans=0;
         if(d[i][j]<0){
            if(pos==0){
                ans=Math.abs(d[i][j]);
             } 
            else if(pos>Math.abs(d[i][j])){
                pos=pos-Math.abs(d[i][j]);
            }
            else{
                ans=Math.abs(Math.abs(d[i][j])-pos);
                pos=0;
            }
        }
        else{
            pos+=d[i][j];
        }
        ans+=Math.min(rec(d,i+1,j,pos),rec(d,i,j+1,pos));
          System.out.println(i+" "+j+" " + ans);
       return ans;
    }
}