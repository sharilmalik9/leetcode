// https://leetcode.com/problems/word-break-ii

class Solution {
    List<List<String>> ans= new ArrayList<>();
    HashSet<String> hs= new HashSet<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String m:wordDict){
            hs.add(m);
        }
        List<String> ls=new ArrayList<>();
        rec(s,0,ls);
        List<String> hehe= new ArrayList<>();
        System.out.println(ans);
         for(List<String> curr: ans){
             StringBuilder sb= new StringBuilder();
             for(int i=0;i<curr.size()-1;i++){
               sb.append(curr.get(i));
               sb.append(" ");
            }
            sb.append(curr.get(curr.size()-1));
             hehe.add(sb.toString());
         }
        return hehe;


    }
    public void rec(String s,int i,List<String> ls){
        if(i==s.length()){
            ans.add(new ArrayList<>(ls));
            return;
        } 
        for(int k=i;k<s.length();k++){
            if(hs.contains(s.substring(i,k+1))){
                ls.add(s.substring(i,k+1));
                rec(s,k+1,ls);
                ls.remove(ls.size()-1);
            }

        }
    }
}