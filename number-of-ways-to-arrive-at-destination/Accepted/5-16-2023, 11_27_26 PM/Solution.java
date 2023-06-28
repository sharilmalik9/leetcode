// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination

class Solution {
    int mod=1000000007;
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> ls= new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] i: roads){
            ls.get(i[0]).add(new int[] {i[1],i[2]});
            ls.get(i[1]).add(new int[] {i[0],i[2]});
        }
        int[] dis=new int[n];
        int[] ways=new int[n];
        ways[0]=1;
        Arrays.fill(dis,Integer.MAX_VALUE);
        PriorityQueue<int[]> que= new PriorityQueue<>((a,b)->a[1]-b[1]);
        que.add(new int[] {0,0});
        dis[0]=0;
        while(que.size()!=0){
            int[] curr=que.poll();
            for(int[] i: ls.get(curr[0])){
                if(curr[1]+i[1] < dis[i[0]]){
                    dis[i[0]]=curr[1]+i[1];
                    que.add(new int[] {i[0],dis[i[0]]});
                    ways[i[0]]=ways[curr[0]];
                }
                else if(curr[1]+i[1] == dis[i[0]]){
                    ways[i[0]]=(ways[i[0]]+ways[curr[0]])%mod;

                }
            }

        }
        int dis1=dis[n-1];
         System.out.println(dis1);
        if(dis1==Integer.MAX_VALUE){
            return 0;
        }
       

        return ways[n-1];
        
    }
}