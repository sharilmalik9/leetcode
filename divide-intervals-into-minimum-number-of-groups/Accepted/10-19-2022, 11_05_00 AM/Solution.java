// https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups

class Solution {
    public int minGroups(int[][] intervals){
         Arrays.sort(intervals, (a,b) -> {
            return (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0];
        });
        int ans=1;
        int cnt=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int[] a:intervals){
            int start=a[0];
            int end=a[1];
            if(pq.size()!=0 && pq.peek()<start){
                pq.poll();
}
            pq.offer(end);
        }
        return Math.max(ans,pq.size());
        
    }
}