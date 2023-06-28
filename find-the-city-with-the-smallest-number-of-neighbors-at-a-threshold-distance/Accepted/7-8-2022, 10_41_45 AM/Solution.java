// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance

class Solution {
    public void find(int[][]dist,int j){
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        for(int i=0;i<dist.length;i++){
            if(j != i && dist[j][i] < (int)Math.pow(10,5))
                pq.add(new int[]{i,dist[j][i]});
        }
        
        Set<Integer>set=new HashSet<>();
        while(!pq.isEmpty()){
            int[]tmp=pq.remove();
            
            if(!set.contains(tmp[0])){
            set.add(tmp[0]);
            dist[j][tmp[0]]=tmp[1];
            
            for(int i=0;i<dist.length;i++){
            if(!set.contains(i) && j!=i && dist[j][i] > tmp[1]+dist[tmp[0]][i])
                   pq.add(new int[]{i,tmp[1]+dist[tmp[0]][i]});
            }
            
        }
      }
        
    }
    public int findTheCity(int n, int[][] edges, int k) {
        //Dijsktra algo for every node
        int[][]dist=new int[n][n];
        
        for(int i=0;i<n;i++)
            Arrays.fill(dist[i],(int)Math.pow(10,5));
        
        for(int i=0;i<edges.length;i++){
            dist[edges[i][0]][edges[i][1]]=edges[i][2];
            dist[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        
        for(int i=0;i<n;i++)
            find(dist,i);
        
        int res=n-1;
        int city=n;
        
        for(int i=n-1;i>=0;i--){
            int cnt=0;
            for(int j=0;j<n;j++)
                if(dist[i][j] <= k)cnt++;
            if(city > cnt){
                city=cnt;
                res=i;
            }
        }
        return res;
    }
}