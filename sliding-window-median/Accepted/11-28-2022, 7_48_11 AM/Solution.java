// https://leetcode.com/problems/sliding-window-median

class Solution {
   public double[] medianSlidingWindow(int[] nums, int k) {
	double[] result = new double[nums.length - k + 1];
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	for(int i=0; i<nums.length; i++){
		minHeap.add(nums[i]);
		maxHeap.add(minHeap.poll());
		if(minHeap.size()<maxHeap.size()){
			minHeap.add(maxHeap.poll());
		}

		if(minHeap.size()+maxHeap.size() == k){
			double median;
			if(minHeap.size() == maxHeap.size()){
				median = ((long)minHeap.peek()+(long)maxHeap.peek())/2.0;
			}else{
				median = minHeap.peek();
			}

			int start = i-k+1;
			result[start] = median;
			if(!minHeap.remove(nums[start])){
				maxHeap.remove(nums[start]);
			}
		}
	}
	return result;
}
}