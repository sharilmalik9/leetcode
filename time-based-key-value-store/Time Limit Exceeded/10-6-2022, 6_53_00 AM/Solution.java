// https://leetcode.com/problems/time-based-key-value-store

class TimeMap {
    class pair{
        String value;
        int time;
        pair(String value,int time){
            this.value=value;
            this.time=time;
        }
    }
    HashMap<String,List<pair>> hm;

    public TimeMap() {
        hm=new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
     pair pp= new pair(value,timestamp);
      
      List<pair> ls= hm.getOrDefault(key,new ArrayList<pair>());
        ls.add(pp);
        hm.put(key,ls);
        
    }
    
    public String get(String key, int timestamp) {
        List<pair> curr= hm.getOrDefault(key,new ArrayList<pair>());
        int ans=0;
        String ansf="";
        // System.out.println(curr);
        for(pair p: curr){
            if(p.time<=timestamp){
                if(p.time>ans){
                    ans=p.time;
               //     System.out.println(p.value);
                    ansf=p.value;
                }
            }
        }
        return ansf;
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */