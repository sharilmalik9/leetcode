// https://leetcode.com/problems/two-best-non-overlapping-events

class Solution {
    public int maxTwoEvents(int[][] events) {
        int res = 0, maxVal = 0;
        //Min heap by ending time
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        //Sort the array by start time
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        for (int[] e : events) {
            //Pop all the finished events and maintain maximum value till now
            while (!pq.isEmpty() && pq.peek()[0] < e[0]) {
                maxVal = Math.max(maxVal, pq.poll()[1]);
            }
            //Check for max value
            res = Math.max(res, maxVal + e[2]);
            pq.offer(new int[]{e[1], Math.max(maxVal,e[2])});
        }
        return res;
    }
}