// https://leetcode.com/problems/extra-characters-in-a-string

class Solution {
    HashSet<String> hs ;
    HashMap<Pair<Integer, String>, Integer> dp;
    String s;
    public int minExtraChar(String s, String[] dictionary) {
        this.s=s;
        hs = new HashSet<>();
         dp = new HashMap<>();
        for(String i: dictionary) hs.add(i);
        return rec(0,"");
    }
    
    public int rec(int i, String curr){
        if(i >= s.length()) {
                return curr.length();
        }
        if(dp.containsKey(new Pair<Integer, String>(i, curr))) {
            return dp.get(new Pair<Integer, String>(i, curr));
        }
         int ans2 = 0;
        int ans = 0;
        if(!hs.contains(curr + s.charAt(i))){
            ans2 += 1+ curr.length();
            ans2 += rec(i+1, "");
           
        }else{
            
            ans2 = rec(i+1, "");
        }
        ans = rec(i+1, curr + s.charAt(i));
       
        ans = Math.min(ans,ans2);
        dp.put(new Pair<Integer, String>(i, curr), ans);
        return ans;
    }
    
}