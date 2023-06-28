// https://leetcode.com/problems/total-appeal-of-a-string

class Solution {
    public long appealSum(String s) {
         HashMap<Character,List<Integer>> hm= new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                hm.get(s.charAt(i)).add(i);
            }
            else{
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                hm.put(s.charAt(i),ls);
            }
        }
        long ans=0;
        int left;
        int right;
        for(Character ch: hm.keySet()){
            for(int i=0;i<hm.get(ch).size();i++){
                left= i==0 ? hm.get(ch).get(i)+1 : hm.get(ch).get(i)- hm.get(ch).get(i-1)+1;
                right=i==hm.get(ch).size()-1 ? s.length()-hm.get(ch).get(i) : hm.get(ch).get(i+1)-hm.get(ch).get(i)+1;
                ans+=left*right;

            }
            

        }
        return ans;
    }
}