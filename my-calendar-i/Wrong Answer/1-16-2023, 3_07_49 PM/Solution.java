// https://leetcode.com/problems/my-calendar-i

class MyCalendar {
    HashMap<Integer,Integer> hm;

    public MyCalendar() {
        hm=new HashMap<>();
        
    }
    
    public boolean book(int start, int end) {
        for(int i: hm.keySet()){
            if((hm.get(i)>start && start>=i) || (end<=hm.get(i) && end>i)){
                return false;
            }
        }
        hm.put(start,end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */