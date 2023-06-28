// https://leetcode.com/problems/shortest-path-to-get-all-keys

class Solution {
    class pair{
        int x;
        int y;
        public pair(int x,int y){
            this.x=x;
            this.y=y;

        }
    }
    public int shortestPathAllKeys(String[] grid){
        int[][] dir={{0,-1},{1,0},{0,1},{-1,0}};
        char[][] mat=new char[grid.length][grid[0].length()];
        boolean[][] vis= new boolean[mat.length][mat[0].length];
        HashSet<Character> hs= new HashSet<>();
        Queue<pair> que= new LinkedList<>();
        int keycount=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length();j++){
                mat[i][j]=grid[i].charAt(j);
                if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='f'){
                    keycount++;
                }
                if(grid[i].charAt(j)=='@'){
                    que.add(new pair(i,j));
                    vis[i][j]=true;
                }
            }
        }
        int level=0;
        while(que.size()!=0){
           level++;
            int size=que.size();
            while(size!=0){
                pair curr=que.poll();
                for(int i=0;i<4;i++){
                    int newx=curr.x+dir[i][0];
                    int newy=curr.y+dir[i][1];
                    
                    if(newx<0 || newx>=mat.length || newy<0 || newy>=mat[0].length || vis[newx][newy] ||
                    mat[newx][newy]=='#'){   
                        continue;
                    }
                    if(mat[newx][newy]>='A' && mat[newx][newy]<='F'){
                        if(!hs.contains(Character.toLowerCase(mat[newx][newy]))){
                            continue;
                        }
                    }
                    if(mat[newx][newy]>='a' && mat[newx][newy]<='f'){
                        
                        hs.add(mat[newx][newy]);
                       
                    }
                     if(hs.size()==keycount){
                            return level;
                        }
                    vis[newx][newy]=true;
                   
                    que.add(new pair(newx,newy));

                }
                size--;
            }
        }
        return -1;  
    }
}