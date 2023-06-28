// https://leetcode.com/problems/is-graph-bipartite

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] p= new int[graph.length];
        for(int i=0;i<p.length;i++){
            p[i]=i;
}
        for(int i=0;i<graph.length;i++){
            int parent=graph[i][0];
            for(int j=0;j<graph[i].length;j++){
                union(parent,graph[i][j],p);
                
            }
            
}
        int count=0;
        for(int i=0;i<p.length;i++){
            if(p[i]==i){
                count++;
            }
            
        }
        if(count==2){
            return true;
        }
        return false;
        
        
        
        
        
        
        
    }
    
    
     
    public int parent(int[] p,int x){
        if(p[x]==x){
            return x;
        }
        return parent(p,p[x]);
    }
    public void union(int a,int b,int[] p){
        int x=parent(p,a);
        int y= parent(p,b);
        if(x==y){
            return;
        }
        p[x]=y;



    }

}