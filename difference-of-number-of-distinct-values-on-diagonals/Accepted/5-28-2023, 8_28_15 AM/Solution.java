// https://leetcode.com/problems/difference-of-number-of-distinct-values-on-diagonals

class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        
         int n = grid[0].length;
        int m = grid.length;
          int[][] anshe = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int newii = i+1;
                int newjj= j+1;
                 HashSet<Integer> hso = new HashSet<>();
                while(newii<m && newjj< n){
                    hso.add(grid[newii][newjj]);
                    newii++;
                    newjj++;
                }
                anshe[i][j] = hso.size();
            }
        }
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                int newii = i-1;
                int newjj= j-1;
                HashSet<Integer> hsoo = new HashSet<>();
                while(newii>=0 && newjj>=0){
                    hsoo.add(grid[newii][newjj]);
                    newii--;
                    newjj--;
                }
                anshe[i][j] = Math.abs(anshe[i][j] - hsoo.size());
            }
        }
        
        return anshe;
    }
}