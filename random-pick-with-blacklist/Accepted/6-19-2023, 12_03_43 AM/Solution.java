// https://leetcode.com/problems/random-pick-with-blacklist

class Solution {

    int range;
    Random r;
    HashMap<Integer,Integer> map = new HashMap<>();
    HashSet<Integer> invalid = new HashSet<>();
    
    public Solution(int n, int[] blacklist) {
        range = n - blacklist.length;
        r = new Random();
        map = new HashMap<>();
        invalid = new HashSet<>();
        
        for(int val : blacklist){
            invalid.add(val);
        }
        
        int curr = range;
        for(int val : blacklist){
            if(val < range){
                while(invalid.contains(curr)){
                    curr++;
                }
                map.put(val,curr);
                curr++;
            }
        }
        
    }
    
    public int pick() {
        int res = r.nextInt(range);
        
        if(map.containsKey(res)){
            res = map.get(res);
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */