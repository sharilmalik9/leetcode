// https://leetcode.com/problems/repeated-dna-sequences

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> hm= new HashMap<>();
        List<String> ans= new ArrayList<>();
        if(s.length()<11){
            return ans;
        }
        StringBuilder sb= new StringBuilder(s.substring(0,10));
        hm.put(sb.toString(),1);
       
        for(int i=10;i<s.length();i++){
            System.out.println(sb.toString());
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
           hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+1);
          
        }
        for(Map.Entry<String,Integer> entry : hm.entrySet()) {
            if(entry.getValue() > 1) {
                ans.add(entry.getKey().toString());
            }
        }

        return ans;


    }
}