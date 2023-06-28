// https://leetcode.com/problems/remove-duplicate-letters

class Solution {
    public String removeDuplicateLetters(String s) {
        char[] hm=s.toCharArray();
        Stack<Integer> st=new Stack<>();
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']=i;
        }

        boolean[] vis=new boolean[26];
        for(int i=0;i<hm.length;i++){
            if(st.size()==0){
                vis[hm[i]-'a']=true;
                st.add(i);
            }
            else{
                while(st.size()!=0 && hm[st.peek()]-'a'>hm[i]-'a' && st.peek()!=arr[hm[st.peek()]-'a']){
                    vis[hm[st.pop()]-'a']=false;
                }
                if(!vis[hm[i]-'a']){
                      st.add(i);
                      vis[hm[i]-'a']=true;
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        while(st.size()!=0){
            sb.append(hm[st.pop()]);
        }
        return sb.reverse().toString();
        
    }
}