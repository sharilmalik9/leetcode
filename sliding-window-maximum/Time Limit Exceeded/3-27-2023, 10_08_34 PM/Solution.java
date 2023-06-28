// https://leetcode.com/problems/sliding-window-maximum

class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int n = arr.length;
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < k; i++)
                pq.add(arr[i]);

            ans.add(pq.peek());
            pq.remove(arr[0]);

            for (int i = k; i < n; i++) {
                pq.add(arr[i]);
                ans.add(pq.peek());
                pq.remove(arr[i - k + 1]);
            }

            int a[] = new int[ans.size()];
            for (int j = 0; j < ans.size(); j++)
                a[j] = ans.get(j);

            return a;
        
    }
}