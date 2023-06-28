// https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum

class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        Graph G = new Graph(n, price);
        for(int[] edge: edges) {
            G.addEdge(edge[0], edge[1]);
        }
        G.calcMax();
        return G.ans;
    }
    
    class Graph {
        int V;
        Map<Integer, Node> adj[];
        int[] price;
        long ans = 0;
        
        Graph(int V, int[] price) {
            this.V = V;
            this.adj = new HashMap[V];
            for(int i=0;i<V;i++) {
                adj[i] = new HashMap<>();
            }
            this.price = price;
        }
        
        void addEdge(int u, int v) {
            adj[u].put(v, new Node(u,v));
            adj[v].put(u, new Node(v,u));
        }
        
        long calcMax() {
            int max = 0;
            for(int u=0;u<V;u++) {
                for(Node n: adj[u].values()) {
                    calcMax(n.v, u);
                    //System.out.println(u+" "+n.v+" "+n.max);
                }
            }
            return 0;
        }
        
        long calcMax(int curr, int parent) {
            if(adj[parent].get(curr).max!=0) {
                return adj[parent].get(curr).max;
            }
            long max = 0;
            for(Node n: adj[curr].values()) {
                if(n.v!=parent) {
                    max = Math.max(max, calcMax(n.v, curr));
                }
            }
            adj[parent].get(curr).max = price[curr]+max;
            ans = Math.max(ans, price[curr]+max);
            return price[curr]+max;
        }
    }
    
    class Node {
        int u;
        int v;
        long max;
        
        Node(int u, int v) {
            this.u = u;
            this.v = v;
            this.max = 0;
        }
    }
}