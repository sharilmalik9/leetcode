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
        if(passenger>capacity){
            return false;
}
       List<int[]> ls= new ArrayList<>();
        ls.add(pq.poll());
        while(pq.size()!=0) {
            int[] curr=pq.poll();
           
            int i=0;
            while(i<ls.size()){
                if(ls.get(i)[2]<=curr[1]){
                    passenger-=ls.get(i)[0];
                    ls.remove(i);
                }
                else{
                    i++;
                }
}
            passenger+=curr[0];
            ls.add(curr);
            if(passenger>capacity){
                
                return false;
            }
             
            
        }        
        return true;
    }
}