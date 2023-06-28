// https://leetcode.com/problems/is-graph-bipartite

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] p= new int[graph.length];
        for(int i=0;i<p.length;i++){
            p[i]=i;
}
        for(int i=0;i<graph.length;i++){
            // if(graph[i].length==0){
            //    break;
            // }
            // int parent=graph[i][0];
            
            for(int j=0;j<graph[i].length;j++){
                int parent=graph[i][0];
                union(parent,graph[i][j],p);
                // union(parent,i,p);
                
            }
            
            
            
}
        int count=0;
        int[] freq=new int[p.length];
        for(int i=0;i<p.length;i++){
            freq[p[i]]+=1;
            
            
        }
         System.out.println(Arrays.toString(p));
        System.out.println(Arrays.toString(freq));
        for(int i=0;i<freq.length;i++){
            if(freq[i]>1){
                count++;
            }
            if(freq[i]==1){
                if(graph[i].length>0){
                    count++;
                }
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
        for(int i=0;i<p.length;i++){
            if(p[i]==x){
                p[i]=y;
            }
}
        p[x]=y;



    }

}