// https://leetcode.com/problems/satisfiability-of-equality-equations

class Solution {
    
    public boolean equationsPossible(String[] equations) {
        int[] p= new int[26];
        for(int i=0;i<26;i++){
            p[i]=i;
        }
        for(String str:equations){
            if(str.charAt(1)=='='){
                union(str.charAt(0)-'a', str.charAt(3)-'a',p);
            }
        }
        
        for(String str:equations){
            if(str.charAt(1)=='!'){
                int p1=parent(p,str.charAt(0)-'a');
                int p2=parent(p,str.charAt(3)-'a');
                if(p1==p2){
                    return false;
                }
            }
        }
        
      
        
        return true;
        
    }
    int parent(int[] p,int x){
        if(p[x]==x){
            return x;
        }
        return parent(p,p[x]);
    }
    void union(int a,int b,int[] p){
        int x=parent(p,a);
        int y= parent(p,b);
        if(x==y){
            return;
        }
        p[x]=y;



    }



    
    
    
    
    
    
    
    
    
    
    
}