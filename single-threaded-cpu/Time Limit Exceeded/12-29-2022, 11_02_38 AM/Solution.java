// https://leetcode.com/problems/single-threaded-cpu

class Solution {
    class pair{
        int idx;
        int start;
        int time;
        pair(int idx,int start,int time){
            this.idx=idx;
            this.start=start;
            this.time=time;
        }
    }
    public int[] getOrder(int[][] tasks){
        pair[] arr= new pair[tasks.length];
        int[] ans= new int[tasks.length];
        int idx=0;
        for(int i=0;i<tasks.length;i++){
            pair pp= new pair(i,tasks[i][0],tasks[i][1]);
            arr[i]=pp;
        }
        Arrays.sort(arr,(a,b)-> (a.start==b.start)? a.time-b.time : a.start-b.start);
        int time=arr[0].start;
        time+=arr[0].time;
        ans[idx]=arr[0].idx;
        idx++;
        int idx1=1;
        PriorityQueue<pair> pq= new PriorityQueue<>((a,b)-> (a.time==b.time) ? a.idx-b.idx : a.time-b.time);
        while(idx<ans.length){
             while(idx1<arr.length && arr[idx1].start<=time){
                 pq.add(arr[idx1]);
                 idx1++;
             }
             if(pq.size()!=0){
                 pair curr=pq.poll();
             time+=curr.time;
             ans[idx]=curr.idx;
             idx++;

             }
              else{
                  time++;
              }






        }
       return ans;
    }
}