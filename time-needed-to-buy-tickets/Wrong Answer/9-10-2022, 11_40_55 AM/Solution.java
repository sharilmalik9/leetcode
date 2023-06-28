// https://leetcode.com/problems/time-needed-to-buy-tickets

class Solution {
    public int timeRequiredToBuy(int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
        
        Queue<Integer> q = new LinkedList<>();
        
		for(int i= 0 ;i < input.length ; i++){
			pq.add(input[i]) ;
            q.add(i);
        }
        
        int cnt = 0;
        
		// System.out.println(pq.size());
        // System.out.println(pq.peek());
        
        
        while(true){
            int currIndex = q.poll();
            if(pq.peek() == input[currIndex]){
                if(currIndex == k){
                    break;
                }
                // System.out.println("Index " + currIndex + " removed");
                pq.poll();
                cnt++;
            }else{
                q.add(currIndex);
            }
        }
        
        
        return cnt+1;
    }
}