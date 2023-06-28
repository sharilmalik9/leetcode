// https://leetcode.com/problems/find-a-good-subset-of-the-matrix

class Solution {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < m;j++){
                boolean wrong = false;
                for(int k = 0;k < n;k++){
                    int num = grid[i][k] + grid[j][k];
                    if(num > 1) {
                        wrong = true;break;
                    }
                }
                if(!wrong){
                    res.add(i);
                    if(i != j) res.add(j);
                    return res;
                    
                }
            }
        }
        
        return res;
    }
}