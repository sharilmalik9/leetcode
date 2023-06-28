// https://leetcode.com/problems/detect-cycles-in-2d-grid

class Solution {
    int N, M;
    boolean[][] vis;
    final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean containsCycle(char[][] G) {
        N = G.length; M = G[0].length;
        vis = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!vis[i][j]){        
                    if(dfs(i, j, G, G[i][j], -1, -1))
                        return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int r, int c, char[][] G, char u, int pr, int pc){
        if(vis[r][c])
            return true;
        vis[r][c] = true; 

        for(int[] d : dir){
            int newR = r+d[0], newC = c+d[1];
            if(newR<0||newR>=N||newC<0||newC>=M || G[newR][newC] != u || newR == pr && newC == pc)
                continue;
            if(dfs(newR, newC, G, u, r, c))
                return true;
        }
        return false;
    }
}