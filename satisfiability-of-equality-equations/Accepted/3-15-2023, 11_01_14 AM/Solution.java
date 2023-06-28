// https://leetcode.com/problems/satisfiability-of-equality-equations

class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] p= new int[26];
        for(int i=0;i<26;i++){
            p[i]=i;
        }
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1)=='='){
                union(equations[i].charAt(0)-'a', equations[i].charAt(3)-'a',p);
            }
            
        }
        for(int i=0;i<equations.length;i++){
            if(equations[i].charAt(1)=='!'){
                int x=parent(equations[i].charAt(0)-'a',p);
                int y=parent(equations[i].charAt(3)-'a',p);
                if(x==y){
                    return false;
                }
            }
        }
        return true;
    }
    public void  union(int x,int y,int[] p){
        int px=parent(x,p);
        int py=parent(y,p);
        if(px==py){
            return ;
        }
        p[px]=py;
    }
    public int parent(int x ,int[] p){
        if(p[x]==x){
            return x;
        }
        return parent(p[x],p);
    }
}