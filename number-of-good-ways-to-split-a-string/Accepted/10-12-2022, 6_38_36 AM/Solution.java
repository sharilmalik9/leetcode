// https://leetcode.com/problems/number-of-good-ways-to-split-a-string

class Solution {
    public int numSplits(String s) {
        HashMap<Character,Integer> right= new HashMap<>();
        HashMap<Character,Integer> left= new HashMap<>();
        for(int i=0;i<s.length();i++){
            right.put(s.charAt(i),right.getOrDefault(s.charAt(i),0)+1);
        }
        int cnt=0;
        for(int i=0;i<s.length();i++){
            left.put(s.charAt(i),left.getOrDefault(s.charAt(i),0)+1);
            right.put(s.charAt(i),right.getOrDefault(s.charAt(i),0)-1);
            if(right.get(s.charAt(i))==0){
                right.remove(s.charAt(i));
            }
            if(right.size()==left.size()){
                cnt++;
            }
        }
        return cnt;
    }
}