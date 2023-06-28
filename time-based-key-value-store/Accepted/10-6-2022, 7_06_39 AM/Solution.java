// https://leetcode.com/problems/time-based-key-value-store

class TimeMap {
    HashMap<String, TreeMap<Integer, String>> hm=new HashMap<>();
    public TimeMap() {
        hm=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key))
            hm.put(key, new TreeMap<>());
        hm.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        var v=hm.get(key).floorKey(timestamp);
        if(v==null) return "";
        return hm.get(key).get(v);
    }
}