// https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital

class Solution {
    long fuel=0;
    public long minimumFuelCost(int[][] roads, int seats){
        List<List<Integer>> tree=new ArrayList<>();
        int n=roads.length;
        for(int i=0;i<n+1;i++){
            tree.add(new ArrayList<>());
        }
        for(int[] i:roads){
            tree.get(i[0]).add(i[1]);
            tree.get(i[1]).add(i[0]);
        }
        help(tree,seats,0,new int[n+1]);
        return fuel;

        
    }
     public long help(List<List<Integer>> tree,int seats,int curr,int[] vis){
         double c=0;
         if(curr!=0){
             c=1;

         }
         vis[curr]=1;
         for(int i: tree.get(curr)){
             if(i!=curr && vis[i]==0){
                 c+=help(tree,seats,i,vis);
             }
         }
         if(curr!=0){
             fuel+=(long)Math.ceil(c/seats);
         }
         return (long)c;
     }
}