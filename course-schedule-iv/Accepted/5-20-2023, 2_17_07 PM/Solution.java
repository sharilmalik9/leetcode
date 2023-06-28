// https://leetcode.com/problems/course-schedule-iv

class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] preReqs, int[][] queries){
        int[] inDegree=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<preReqs.length;i++) {
            adj.get(preReqs[i][0]).add(preReqs[i][1]);
            inDegree[preReqs[i][1]]++;
        }
        boolean[][] isPreq=new boolean[n][n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0) q.add(i); 
        }
        while(!q.isEmpty()){
            int node=q.poll();
            for(int adjNode:adj.get(node)){
                isPreq[node][adjNode]=true;
                for(int i=0;i<n;i++){
                    if(isPreq[i][node]) isPreq[i][adjNode]=true;
                }
                inDegree[adjNode]--;
                if(inDegree[adjNode]==0) q.add(adjNode);
            }
        }
        List<Boolean> res=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int first=queries[i][0];
            int second=queries[i][1];
            res.add(isPreq[first][second]);
        }
        return res;
    }
} 
