// https://leetcode.com/problems/car-pooling

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // glti se bhi discuss nhi dekhna sirf ques kro khud se 
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> a[1]==b[1] ? a[2]-b[2] : a[1]-b[1]);
        for(int[] i: trips){
            pq.add(i);
        }
        int passenger=pq.peek()[0];
        int start=pq.peek()[1];
        int end=pq.peek()[2];
        Queue<int[]> que= new LinkedList<>();
        que.offer(pq.poll());
        while(pq.size()!=0) {
            int[] curr=pq.poll();
            
            while(que.size()!=0 && que.peek()[2]<=curr[1]){
                passenger-=que.poll()[0];
                
            }
            passenger+=curr[0];
            que.add(curr);
            if(passenger>capacity){
                return false;
            }
             
            
        }        
        return true;
    }
}