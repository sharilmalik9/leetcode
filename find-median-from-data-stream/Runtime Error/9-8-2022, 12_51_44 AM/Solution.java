// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {
PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        large= new PriorityQueue<>();
        small= new PriorityQueue<>((a,b)->b-a);
        
    }
    
    public void addNum(int num) {
        if(small.size()==0){
            small.add(num);
            return;
        }
        else if(large.size()==0){
            large.add(num);
            return;
            
        }
        if(small.size()!=0 && large.size()!=0){

        int prev=small.peek();
        int upcoming=large.peek();
        if(num<prev){
            small.add(num);
        }
        else{
            large.add(num);
        }
        }
        if(small.size()>large.size()){
            large.add(small.poll());
        }
        else if (large.size()-small.size()>1){
            small.add(large.poll());
        }
        
    }
    
    public double findMedian() {
        double ans=0;
        if(small.size()==large.size()){
            return (small.peek()+large.peek())/2.0;
        }
        return large.peek();
        
        
       
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */