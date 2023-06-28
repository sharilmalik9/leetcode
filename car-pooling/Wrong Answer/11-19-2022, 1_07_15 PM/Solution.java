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
        pq.poll();
        while(pq.size()!=0)
        {
            int[] curr=pq.poll();
            if(curr[1]<end){
                passenger+=curr[0];
                if(passenger>capacity){
                    return false;
                }
                else{
                     start=Math.min(start,curr[1]);
                      end=Math.max(end,curr[2]);
                }
            }
            else{
                passenger=curr[0];
                if(passenger>capacity){
                    return false;
                }
                start=curr[1];
                end=curr[2];
            }
            
        }        
        return true;
        
    }
}