// https://leetcode.com/problems/min-stack

class MinStack {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    ArrayList<Integer> res = new ArrayList<>();
    public void push(int val) {
        res.add(val);
        pq.add(val);
    }
    
    public void pop() {
        pq.remove(res.get(res.size() - 1));
        res.remove(res.size() - 1);
    }
    
    public int top() {
        
        return res.get(res.size()- 1);
    }
    
    public int getMin() {
        // res.remove(pq.peek());
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */