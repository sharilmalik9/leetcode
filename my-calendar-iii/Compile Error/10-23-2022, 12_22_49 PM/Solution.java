// https://leetcode.com/problems/my-calendar-iii

class MyCalendarThree {
     HashMap<Integer,Integer> hm;
   
   // HashMap<pair,Integer> hm;
    public MyCalendarThree() {
        hm=new HashMap<>(); 
        
    }
    
    public int book(int start, int end) {
        int cnt=0;
        for(Entry<Integer,Integer> entry: hm.entrySet()) {
          
            if((start>=entry.getKey() && start<=entry.getValue()) || (end>=entry.getKey()&&entry.getValue()>=end)){
                cnt++;
            }
            
        }
        hm.put(start,end);
        
        return cnt;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */