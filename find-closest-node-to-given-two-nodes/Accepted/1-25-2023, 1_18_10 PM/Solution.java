// https://leetcode.com/problems/find-closest-node-to-given-two-nodes

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1=new int[edges.length];
        int[] dis2=new int[edges.length];
        cal(edges,node1,dis1);
        cal(edges,node2,dis2);
        int ans=-1;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<dis1.length;i++){
            if(dis1[i]==-1 || dis2[i]==-1){
                continue;
            }
            int max=Math.max(dis1[i],dis2[i]);
            if(res>max){
                res=max;
                ans=i;
            }
        }
        System.out.println(Arrays.toString(dis1));
          System.out.println(Arrays.toString(dis2));
        return ans;
    }

    public void cal(int[] edges, int node,int[] dis1){
        Arrays.fill(dis1,-1);
        Queue<Integer> que= new LinkedList<>();
        dis1[node]=0;
        que.add(node);
        while(que.size()>0){
            int curr=que.poll();
            int next=edges[curr];
            if(next!=-1 && dis1[next]==-1){
                dis1[next]=1+dis1[curr];
                que.add(next);
            }
             
        }
    }
}