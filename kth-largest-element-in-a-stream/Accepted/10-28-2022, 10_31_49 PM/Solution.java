// https://leetcode.com/problems/kth-largest-element-in-a-stream

class KthLargest {

    private PriorityQueue<Integer> minHeap;
    int heapSize;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        heapSize = k;

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > heapSize) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > heapSize) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */