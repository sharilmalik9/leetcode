// https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests

class Solution {
       //records how many load each server worked on.
    int[] cnt;
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        //only need K servers.
		cnt = new int[k];
        int n = arrival.length, max = 0;
        //record <idx, endTime> to record each server's free time start point 
        PriorityQueue<int[]> busy = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        //need to find >= (i % k) th sever, which needs servers in order, and ceiling function.
        TreeSet<Integer> free = new TreeSet();
        for(int i = 0 ; i < k; i++) {
            free.add(i);
        }
        for(int i = 0 ; i < n; i++){
            int start = arrival[i];
            int end = start + load[i];
            //add back all previous buys servers to free, if they can pick up new taskes.
			// each task is arrival in increasing start time order.
            while(!busy.isEmpty() && busy.peek()[1] <= start) {
                free.add(busy.poll()[0]);
            }
            //find the >= (i%K)
            Integer server = free.ceiling(i % k);
            if(server == null) {
                //if no bigger one, start from 0;
                server = free.ceiling(0);
            }
            //need to drop the task
            if(server == null) continue;
            free.remove(server);
            //means one server is doing something
            busy.add(new int[]{server, end});
            max = Math.max(max, ++cnt[server]);
        }
        
        List<Integer> res = new ArrayList();
        for(int i = 0 ; i < k; i++) {
            if(cnt[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}