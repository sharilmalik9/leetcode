// https://leetcode.com/problems/map-sum-pairs

class MapSum {
    HashMap<String,Integer> hm;
    public MapSum() {
        hm= new HashMap<>();
    }
    public void insert(String key, int val) {
        if(hm.containsKey(key)){
            hm.replace(key,val);
        }
        else{
            hm.put(key,val);
        }
          System.out.println(hm);
    }
    public int sum(String prefix) {
        List<String> ls= new ArrayList<>(hm.keySet());
        System.out.println(hm);
        int cnt=0;
        for(String s:ls){
          //  System.out.println(s);
            boolean check=true;
            if(s.length()<prefix.length()){
                return 0;
            }
            for(int i=0;i<prefix.length();i++){
                if(prefix.charAt(i)!=s.charAt(i)){
                    check=false;
                }  
            }
            if(check){
                cnt+=hm.get(s);
            }
        }
        return cnt; 
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */