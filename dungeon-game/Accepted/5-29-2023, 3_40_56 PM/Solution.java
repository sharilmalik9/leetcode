// https://leetcode.com/problems/dungeon-game

// my code 
// thoda togh 
// but remember tabulation of this 

// class Solution {
//     int[][] dp;
//     public int calculateMinimumHP(int[][] d) {
//         dp= new int[d.length][d[0].length];
//         for(int[] i:dp){
//             Arrays.fill(i,-1);
//         }
//         return 1+rec(d,0,0,0);
//     }
//     public int rec(int[][] d,int i,int j,int pos){
        
       
//         if(i==d.length-1 && j==d[0].length-1){
//             if(d[i][j]<0 && pos<Math.abs(d[i][j])){
//                 System.out.println(Math.abs(d[i][j])-pos);
//               return  Math.abs(d[i][j])-pos;
//             }
//           //
          
//            // System.out.println(i+" "+j+ " "+pos);
//             return 0;
//         }
//         if(i>=d.length || j>=d[0].length){
//             return Integer.MAX_VALUE;
//         }
//         // if(dp[i][j]!=-1){
//         //     return dp[i][j];
//         // }
//         int ans=0;
//          if(d[i][j]<0){
//             if(pos==0){
//                 ans=Math.abs(d[i][j]);
//              } 
//             else if(pos>Math.abs(d[i][j])){
//                 pos=pos-Math.abs(d[i][j]);
//             }
//             else{
//                 ans=Math.abs(Math.abs(d[i][j])-pos);
//                 pos=0;
//             }
//         }
//         else{
//             pos+=d[i][j];
//         }
//         ans+=Math.min(rec(d,i+1,j,pos),rec(d,i,j+1,pos));
//           System.out.println(i+" "+j+" " + ans);
//        return ans;
//     }
// }
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

    // if power required to reach a cell is positive then we place zero there instead of the positive number
   // this is to calculate the max negative number we should tackle during the path and we only take the negative value
        int r = dungeon.length;
        int c = dungeon[0].length;
        int [][] dp = new int[r][c];
        
        for(int i= r-1; i>=0;i--)
        {
            for(int j= c-1; j>=0;j--)
            {
			// for where the princess is located, if negative value then take the negative value else if positive then take zero
                if(i==r-1 && j==c-1)// princess is located
                {
                    dp[i][j]= Math.min(0,dungeon[i][j] );
                }
                   // last row move right and check and follow the same process as above  i. e add the value first of the dungeon matrix first and check
				   // if positive or negative and process as above
                else if(i== r-1) // last row
                {
                    dp[i][j] = Math.min(0, dungeon[i][j] + dp[i][j+1]);
                }
                // same as above
                 else if(j == c-1) // last column
                {
                    dp[i][j] = Math.min(0, dungeon[i][j] + dp[i+1][j]);
                }
                // for choosing between down and right direction get the max value as we need the max negative value for the knight to safely travel
				// and process the whole as same as above 
                else 
                {
                    dp[i][j] = Math.min(0, dungeon[i][j] + Math.max(dp[i][j+1], dp[i+1][j]));
                }
            
            }
        }
         return Math.abs(dp[0][0]) +1;                                  
  }
}