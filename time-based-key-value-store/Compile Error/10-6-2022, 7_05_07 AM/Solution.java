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
      //  int ans=0;
      ////  String ansf="";
        // System.out.println(curr);
        // for(pair p: curr){
        //     if(p.time<=timestamp){
        //         if(p.time>ans){
        //             ans=p.time;
        //        //     System.out.println(p.value);
        //             ansf=p.value;
        //         }
        //     }
        // }
        return search(curr,timestamp);
        
    }
    public String search(List<pair> ls,int timestamp){
        int start=0;
        String ans="";
        int end=ls.size()-1;
        if(ls.get(start).time>timestamp){
            return "";
        }
        if(ls.get(end).time<=timestamp){
            return ls.get(end).value;
        }
        while(start<=end){
            int mid=(start+end)/2;
            if(ls.get(mid).time==timestamp){
                return ls.get(mid).value;
            }
            else if(timestamp>ls.get(mid).time){
               
                end--;
                 ans=ls.get(end).value;
                
                
}
            else if(timestamp<){
                start++;
            }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */