// https://leetcode.com/problems/count-submatrices-with-all-ones

class Solution {
    public int numSubmat(int[][] mat) {
       
        int m =mat.length;
        int n=mat[0].length;
        int cnt=0;
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(mat[i][j]==1){
//                     cnt++;
//                 }
// }
//         }
        int[][] dp= new int[m][n];
         if(mat[0][0]==1){
            dp[0][0]=1;
        }
        int ans=countSquares(mat);
         int hor=0;
        for(int k=0;k<m;k++){
            dp[k][0]=mat[k][0];
            hor+=dp[k][0];
            if(dp[k][0]==1){
                cnt++;
            }
            
        }
       
       for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                if(mat[i][j]==1){
                    cnt++;
                    dp[i][j]=dp[i][j-1]+1;
                    hor+=dp[i][j];
                    
                   
                 } 
             }
        }
        int ver=0;
       dp= new int[m][n];
          for(int k=0;k<n;k++){
            dp[0][k]=mat[0][k];
             ver+=dp[0][k];
        }
       for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[j][i]==1){
                   
                    dp[j][i]=dp[j-1][i]+1;
                    ver+=dp[j][i];
                    
                   
                 } 
             }
        }
        
        
        
        
        
        
        ans=hor+ver+ans;
        return ans-2*cnt;
        
    }
    
    
    
    
     public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n = matrix[0].length;
        int[][] dp= new int[m][n];
        for(int i=0;i<m;i++){
           dp[i][0]=matrix[i][0];
        }
        for(int i=0;i<n;i++){
          dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans+=dp[i][j];
            }
        }
        
        return ans;
}
}