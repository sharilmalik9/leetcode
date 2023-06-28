// https://leetcode.com/problems/parallel-courses-iii

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] maxTime = new int[n];
        int[] indegree = new int[n];
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] rel: relations){
            adj.get(rel[0]-1).add(rel[1]-1);
            indegree[rel[1]-1]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        for(int i=0;i<n;i++){
            maxTime[i] = time[i];
        }
        int duration = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> nbrs = adj.get(cur);
            for(int nbr: nbrs){
                indegree[nbr]--;
                maxTime[nbr] = Math.max(maxTime[nbr], maxTime[cur]+time[nbr]);
                if(indegree[nbr] == 0)
                    q.add(nbr);
            }
            duration = Math.max(duration, maxTime[cur]);
        }
        return duration;
    }
}