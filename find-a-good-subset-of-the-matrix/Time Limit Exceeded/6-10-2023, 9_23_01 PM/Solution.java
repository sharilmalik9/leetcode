// https://leetcode.com/problems/find-a-good-subset-of-the-matrix

class Solution {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grids) {
        List<List<Integer>> grid=new ArrayList<>();
        for(int i=0;i<grids.length;i++){
            grid.add(new ArrayList<>());
            for(int j=0;j<grids[0].length;j++){
                grid.get(i).add(grids[i][j]);
            }
                  }
         int n = grid.size();
         int m = grid.get(0).size();
        for (int i = 0; i < n; i++) {
            if (sumnikalo(grid.get(i)) == 0) {
                return List.of(i);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += grid.get(i).get(k) & grid.get(j).get(k);
                }
                if (sum == 0) {
                    return List.of(i, j);
                }
            }
        }
        return new ArrayList<>();
    
        
    }
     public int sumnikalo( List<Integer> row) {
        int sum = 0;
        for (int i = 0; i < row.size(); i++) {
            sum += row.get(i);
        }
        return sum;
    }
}