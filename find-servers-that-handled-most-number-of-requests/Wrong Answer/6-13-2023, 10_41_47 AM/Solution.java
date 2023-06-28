// https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> servers =new TreeSet<>();
        for(int i=0;i<load.length;i++){
            servers.add(i);
        }
        int[] ans=new int[load.length];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<arrival.length;i++){
            int start=arrival[i];
            while(pq.size()!=0 && pq.peek()[0]<=start){
                servers.add(pq.poll()[1]);

            }
             Integer val=servers.ceiling(i%k);
            if(val==null){
                val=servers.ceiling(0);
            }
            else if(val==null){
                continue;
            }
            else{
               
                servers.remove(val);
                pq.add(new int[] {load[val]+start,val});
                ans[val]+=1;
            }
        }
        int hehe=0;
        for(int i=0;i<ans.length;i++){
            hehe=Math.max(hehe,ans[i]);
        }
        List<Integer> hm=new ArrayList<>();
        for(int i=0;i<ans.length;i++){
            if(ans[i]==hehe){
                hm.add(i);
            }
        }
        return hm;
    }
}