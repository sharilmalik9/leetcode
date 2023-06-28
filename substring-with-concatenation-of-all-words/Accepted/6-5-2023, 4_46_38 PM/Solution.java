// https://leetcode.com/problems/substring-with-concatenation-of-all-words

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String he:words){
            hm.put(he,hm.getOrDefault(he,0)+1);
        }
        List<Integer> ans=new ArrayList<>();
        int len=words[0].length();
        int cnt=words.length;
        int window=words.length*len;
        for(int i=0;i<s.length()-window+1;i++){
            HashMap<String,Integer> curr=new HashMap<>();
            int j=0;
            while(j<cnt){
                String str=s.substring(i+j*len,i+j*len+len);
                if(hm.containsKey(str)){
                    curr.put(str,curr.getOrDefault(str,0)+1);
                    if(curr.get(str)>hm.get(str)){
                        break;
                    }

                }
                else{
                    break;
                }
                j++;
            }
            if(j==cnt){
                ans.add(i);
            }


        }
        return ans;
    }
}