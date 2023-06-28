// https://leetcode.com/problems/find-median-from-data-stream

class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        large= new PriorityQueue<>();
        small= new PriorityQueue<>((a,b)->b-a);
        
    }
    
    public void addNum(int num) {
        small.add(num);
        large.add(small.poll());
        if(small.size()<large.size()){
            small.add(large.poll());
        }
        
    }
    
    public double findMedian() {
        if(small.size()==large.size()){
            return (small.peek()+large.peek())/2.0;
        }
        return small.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */