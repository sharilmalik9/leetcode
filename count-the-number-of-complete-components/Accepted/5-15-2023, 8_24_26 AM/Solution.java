// https://leetcode.com/problems/count-the-number-of-complete-components

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] i: edges){
            ls.get(i[0]).add(i[1]);
            ls.get(i[1]).add(i[0]); 
        }
         boolean[] vis= new boolean[n];
         int[] c=new int[n];
         int no=1;
         int ans=0;
         for(int i=0;i<n;i++){
             if(!vis[i]){
             int curr=dfs1(ls,vis,i,c,no);
            
             if(check(c,curr,ls,no)){
                 ans++;
             }
         }
             no++;
        }
        return ans ;
        
    }
     public int dfs1(List<List<Integer>> ls,boolean[] vis ,int idx,int[] c,int count){
        vis[idx]=true;
        c[idx]=count;
        int ans=1;
 
        for(int i:ls.get(idx)){
            if(!vis[i]){
                ans+=dfs1(ls,vis,i,c,count);
            }
        }
        return ans;
        
    }
    public boolean check(int[] c, int count,List<List<Integer>> ls,int no){
        for(int i=0;i<c.length;i++){
            if(c[i]==no){
                if((ls.get(i).size())!=count-1){
                    return false;
                }
            }
        }
        return true;

    }
 
}