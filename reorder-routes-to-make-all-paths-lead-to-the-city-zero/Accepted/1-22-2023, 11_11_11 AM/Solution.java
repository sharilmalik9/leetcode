// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero

class Solution {
    int ans=0;
    // ls= outgoing
    // ls1= incoming
     boolean[] vis;
    public int minReorder(int n, int[][] connections){
        List<List<Integer>> ls= new ArrayList<>();
        List<List<Integer>> ls1= new ArrayList<>();
        

        vis=new boolean[n];
        boolean[] cs=new boolean[n];
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
            ls1.add(new ArrayList<>());
        }
        Queue<Integer> que= new LinkedList<>();
        for(int[] curr : connections ){
            ls.get(curr[0]).add(curr[1]);
            ls1.get(curr[1]).add(curr[0]);
            if(curr[1]==0){
                vis[curr[0]]=true;
                cs[curr[0]]=true;
                que.add(curr[0]);
            }
        }
        vis[0]=true;
        cs[0]=true;
        for(int i:ls.get(0)){
            ans++;
            vis[i]=true;
            cs[i]=true;
            que.add(i);
        }
        while(que.size()!=0){
            int curr=que.poll();
          
            
                for(int i: ls1.get(curr)){
                    if(!cs[i]){
                         que.add(i);
                         cs[i]=true;

                    }
                   
                    vis[i]=true;
                }


            
            for(int i: ls.get(curr)){
                if(!vis[i]){
                    ans++;
                    vis[i]=true;
                }
                if(!cs[i]){
                         que.add(i);
                         cs[i]=true;

                    }

            }
            
        }  
        return ans;
    }
}