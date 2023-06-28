// https://leetcode.com/problems/course-schedule

class Solution {

    bool checkcycle(int node ,vector<vector<int>> &adj ,vector<int> &vis, vector<int> &dfsvis){
        vis[node]=true;
        dfsvis[node]=true;

        for(auto i: adj[node]){
            if(!vis[i]){
               bool flag= checkcycle(i, adj ,vis,dfsvis);
               if(flag){
                   return true;
               }
            }
            else{
                if(dfsvis[i]){
                    return true;
                }
            }
        }
  dfsvis[node]=false;
        return false;
    }

public:
    bool canFinish(int numCourses, vector<vector<int>>& pre) {

        int n=numCourses;

        vector<vector<int>> adj(n);

        int edges=pre.size();
        for(int i=0 ;i<edges;i++){
            int u=pre[i][1];
            int v=pre[i][0];
            adj[u].push_back(v);
        }

        vector<int> vis(n,0);
        vector<int> dfsvis(n,0);

        for(int i=0 ;i<n;i++){
            if(!vis[i]){
                bool flag=checkcycle(i,adj,vis,dfsvis);
                if(flag){
                    return false;
                }
            }
        }


        return true;
    }
};