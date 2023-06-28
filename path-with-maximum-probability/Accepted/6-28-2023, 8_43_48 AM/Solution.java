// https://leetcode.com/problems/path-with-maximum-probability

class Solution {
    static class pair{
        int node;
        double probability;
        pair(int node,double probability){
            this.node=node;
            this.probability=probability;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
         ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new pair(edges[i][1],succProb[ i]));
            adj.get(edges[i][1]).add(new pair(edges[i][0],succProb[ i ]));
        }

        double[] ans=new double[n];
        Arrays.fill(ans, 0.0);
        ans[start]=1;
        PriorityQueue<pair> q = new PriorityQueue<>((a,b)->{
            if(b.probability>a.probability){
                return 1;
            }
            return -1;

        });
        q.add(new pair(start,1));
        while (!q.isEmpty()){
            pair temp=q.poll();
            int node= temp.node;
            double prob= temp.probability;
            for (pair k: adj.get(node)){
                int cnode=k.node;
                double cprob=k.probability;
                if (ans[cnode]==0.0) {
                    ans[cnode] = cprob*prob;
                    q.add(new pair(cnode,ans[cnode]));
                }
                else if (prob * cprob > ans[cnode]){
                    ans[cnode]=prob * cprob;
                    q.add(new pair(cnode,ans[cnode]));
                }
            }
        }
        if (ans[end]==0.0)
            return 0.0;
        return ans[end];
    }
}