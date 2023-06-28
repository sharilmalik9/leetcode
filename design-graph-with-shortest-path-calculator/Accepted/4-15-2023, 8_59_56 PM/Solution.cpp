// https://leetcode.com/problems/design-graph-with-shortest-path-calculator

class Graph {
public:
    vector<vector<pair<int,int>>> adj;
    int n;
    Graph(int N, vector<vector<int>>& edges) {
        adj.resize(N);
        n=N;
        
        
        for(auto edge:edges){
            adj[edge[0]].push_back({edge[1],edge[2]});
        }
        
        
        
    }
    
    void addEdge(vector<int> edge) {
        
        adj[edge[0]].push_back({edge[1],edge[2]});
        
    }
    
    int shortestPath(int node1, int node2) {
        
        priority_queue< pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>> >pq;
        vector<int> mindist(n, INT_MAX);
        mindist[node1]=0;
        vector<int>  vis(n,0);
        pq.push({0, node1});
        while(!pq.empty())
        {
            auto p=pq.top();
            pq.pop();
            int node=p.second;
            if(vis[node]) continue;
            vis[node]=1;
            int nodeDistance=p.first;
            for(auto ad : adj[node])
            {
                int neighbour=ad.first;
                int weight=ad.second;
                if(nodeDistance+weight<mindist[neighbour])
                {
                    mindist[neighbour]=nodeDistance+weight;
                    pq.push({mindist[neighbour], neighbour});
                }
            }
        }
        
        if(mindist[node2]==INT_MAX)return -1;
        return mindist[node2];
        
    }
};