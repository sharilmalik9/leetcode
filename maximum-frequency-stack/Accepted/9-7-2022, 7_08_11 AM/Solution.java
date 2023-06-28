// https://leetcode.com/problems/maximum-frequency-stack

// class FreqStack {
//     TreeMap<Integer,List<Integer>> pq;
//     HashMap<Integer,Integer> hm;
    

//     public FreqStack() {
//         pq= new TreeMap<>(Collections.reverseOrder());
//         hm= new HashMap<>();
        
//     }
    
//     public void push(int val) {
//        int freq=hm.getOrDefault(val,0)+1;
//         hm.put(val,freq);
//         if(pq.containsKey(freq)){
//             pq.get(freq).add(val);
//         }
//         List<Integer> curr= new ArrayList<>();
//         curr.add(val);
//         pq.put(freq,curr);
        
//     }
    
//     public int pop() {
//         Map.Entry<Integer,List<Integer>> freq= pq.pollFirstEntry();
//         List<Integer> ls= freq.getValue();
//         int item=ls.get(ls.size()-1);
        
//         hm.put(item,hm.getOrDefault(item,0)-1);
//         ls.remove(ls.size()-1);
//         if(ls.size()>0){
//             pq.put(freq.getKey(),ls);
//         }
//         return item;
        
        
//     }
// }
class FreqStack {

    Map<Integer, Integer> map; // add <number, frequency>
    TreeMap<Integer, List<Integer>> equalFreq; // add <frequency, list< numbers with this frequency>>
    
    public FreqStack() {
        map = new HashMap();
        equalFreq = new TreeMap(Collections.reverseOrder()); // sort keys descending to get most frequent numbers in pollFirstEntry()
    }
    
    public void push(int val) {
        
        map.put(val, map.getOrDefault(val, 0)+1);
        
        int freq = map.get(val);
        if(!equalFreq.containsKey(freq)) 
            equalFreq.put(freq, new ArrayList());
        equalFreq.get(freq).add(val);
  
    }
    
    public int pop() {
                    
       Map.Entry<Integer, List<Integer>> entry = equalFreq.pollFirstEntry(); // poll the list with most frequest numbers
       List<Integer> curVals = entry.getValue();
       int res = curVals.get(curVals.size() - 1);
       map.put(res, map.getOrDefault(res, 0)-1); // update the frequency of the number in map
       curVals.remove(curVals.size() - 1); // update the list by removing the value
       if(curVals.size() > 0) // if size of list is zero we don't need to put back in TreeMap, no more numbers with that frequecy exists
           equalFreq.put(entry.getKey(), curVals); 
    return res;

    }
}
// Map.Entry<Integer, List<Integer>> entry = equalFreq.pollFirstEntry(); // poll the list with most frequest numbers
//        List<Integer> curVals = entry.getValue();
//        int res = curVals.get(curVals.size() - 1);
//        map.put(res, map.getOrDefault(res, 0)-1); // update the frequency of the number in map
//        curVals.remove(curVals.size() - 1); // update the list by removing the value
//        if(curVals.size() > 0) // if size of list is zero we don't need to put back in TreeMap, no more numbers with that frequecy exists
//            equalFreq.put(entry.getKey(), curVals); 
//     return res;

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */