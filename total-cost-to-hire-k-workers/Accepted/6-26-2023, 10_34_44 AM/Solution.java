// https://leetcode.com/problems/total-cost-to-hire-k-workers

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;
        PriorityQueue<Integer> first = new PriorityQueue<>();
        PriorityQueue<Integer> last = new PriorityQueue<>();
        int i = 0;
        int j = len - 1;
        int hired = 0;
        long ans = 0;
        while(hired != k)
        {
            while(first.size() < candidates && i <= j)
                first.offer(costs[i++]);
            while(last.size() < candidates && i <= j)
                last.offer(costs[j--]);
            
            int cost1 =  Integer.MAX_VALUE;
            int cost2 =  Integer.MAX_VALUE;

            if(!first.isEmpty())
                cost1 = first.peek();
            if(!last.isEmpty())
                cost2 = last.peek();

            if(cost1 <= cost2)
                ans += first.poll();
            else
                ans += last.poll();
            hired++;
        }
        return ans;
    }
}