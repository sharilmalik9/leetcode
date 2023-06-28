// https://leetcode.com/problems/parallel-courses-iii

class Solution {
    List<List<Integer>> adj=new ArrayList<>();
    public int minimumTime(int n, int[][] relations, int[] time) {
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());
        for(int a[] : relations){
            adj.get(a[0]).add(a[1]);
        }

        if(n == 1)return time[0];

        int indegree[]=new int[n+1];
        for(int a[] : relations){
            indegree[a[1]]++;
        }
       
        PriorityQueue<int []> pq=new PriorityQueue<>((x,y) -> x[0] - y[0]);
        for(int i=1;i<=n;i++){
             if(indegree[i] == 0){
                 int tn=time[i-1];
                 pq.add(new int[] {tn , i});
             }
        }
        
        int max=0;
        while(pq.size()>0){
            int cur[]=pq.remove();
             int dist=cur[0];
             int node=cur[1];

            max=Math.max(max , dist);       // for single node component

            for(int edg : adj.get(node)){
                 indegree[edg]--;
                 if(indegree[edg] == 0){
                     int newtime = dist + time[edg-1];
                     max=Math.max(max , newtime);
                     pq.add(new int[] {newtime , edg});
                 }
             }
        }

        return max;
    }
}