// https://leetcode.com/problems/largest-color-value-in-a-directed-graph

class Solution {
    public int largestPathValue(String str, int[][] edges) {

        int n = str.length();

        int[][] colors = new int[n][26];

        int[] inDeg = new int[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i =0 ; i< n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i< edges.length ; i++){
            inDeg[edges[i][1]]++;
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i< n; i++){
            if(inDeg[i] == 0){
                colors[i][str.charAt(i)-'a'] =1;
                q.add(i);
            }
        }

        int visited= 0;

        int max = 0;

        while(!q.isEmpty()){

            int curr = q.poll();
            visited ++;

            for(int u : adj.get(curr)){
                for(int i = 0; i< 26; i++){
                    colors[u][i]= Math.max(colors[u][i], i == str.charAt(u)-'a'? colors[curr][i]+1 : colors[curr][i] );
                }

                inDeg[u] --;
                if(inDeg[u] == 0){
                    q.add(u);
                }
            }
            for(int i =0; i< 26; i++){
                max = Math.max(max,colors[curr][i]);
            }

            // System.out.println(curr + " " + max);
        }

        // for(int i = 0 ; i< colors.length ; i++)
        //     System.out.println(Arrays.toString(colors[i]));
        return visited == n ? max : -1;
        
        
    }
}