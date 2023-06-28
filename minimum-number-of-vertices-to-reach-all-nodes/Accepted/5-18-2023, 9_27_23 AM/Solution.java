// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0; i<n ;i++){
            ls.add(new ArrayList<>());
        }
        int[] indegree=new int[n];
        for(List<Integer> curr : edges){
            ls.get(curr.get(0)).add(curr.get(1));
            indegree[curr.get(1)]++;
        }
        boolean[] vis= new boolean[n];
        List<Integer> ans= new ArrayList<>();
        Queue<Integer> que= new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                ans.add(i);
                que.add(i);
                vis[i]=true;
            }
        }
       
        return ans;
        
    }
}