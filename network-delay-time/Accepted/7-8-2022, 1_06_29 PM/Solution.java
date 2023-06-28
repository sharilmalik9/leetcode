// https://leetcode.com/problems/network-delay-time

class Solution {
    
    class Pair implements Comparable<Pair>{
        int v;
        int wt;
        Pair(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
        public int compareTo(Pair o){
            return this.wt-o.wt;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> g=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            g.add(new ArrayList<>());
        }
        
        for(int i=0;i<times.length;i++){
            int sv=times[i][0];
            int ev=times[i][1];
            int wt=times[i][2];
            List<Integer> t=new ArrayList<>();
            t.add(ev);
            t.add(wt);
            g.get(sv).add(t);
        }
        int dis[]=new int[n+1];
        for(int i=1;i<n+1;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        dis[k]=0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            int v=p.v;
            for(List<Integer> c: g.get(v)){
                int ne=c.get(0);
                int wt=c.get(1);
                if(dis[ne]>dis[v]+wt){
                    dis[ne]=dis[v]+wt;
                    pq.add(new Pair(ne,dis[ne]));
                }
            }
        }
        int ans=0;
        for(int i=1;i<dis.length;i++){
            if(ans<dis[i]){
                ans=dis[i];
            }
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}