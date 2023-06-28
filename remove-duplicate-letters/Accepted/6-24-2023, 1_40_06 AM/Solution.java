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
            if(vis[hm[i]-'a']){
                continue;
            }

        
                while(st.size()!=0  && hm[st.peek()]-'a'>hm[i]-'a' && i<arr[hm[st.peek()]-'a']){
                   
                     vis[hm[st.pop()]-'a']=false;
                   

                }

                
                      st.add(i);
                      vis[hm[i]-'a']=true;
                
            }
        

        StringBuilder sb=new StringBuilder();
        while(st.size()!=0){
            sb.append(hm[st.pop()]);
        }
        return sb.reverse().toString();
        
    }
}
// class Solution {
//     public String removeDuplicateLetters(String s) {
//         int[] lastIndex = new int[26];
//         for (int i = 0; i < s.length(); i++){
//             lastIndex[s.charAt(i) - 'a'] = i; // track the lastIndex of character presence
//         }
        
//         boolean[] seen = new boolean[26]; // keep track seen
//         Stack<Integer> st = new Stack();
        
//         for (int i = 0; i < s.length(); i++) {
//             int curr = s.charAt(i) - 'a';
//             if (seen[curr]) continue; // if seen continue as we need to pick one char only
//             while (!st.isEmpty() && st.peek() > curr && i < lastIndex[st.peek()]){
//                 seen[st.pop()] = false; // pop out and mark unseen
//             }
//             st.push(curr); // add into stack
//             seen[curr] = true; // mark seen
//         }

//         StringBuilder sb = new StringBuilder();
//         while (!st.isEmpty())
//             sb.append((char) (st.pop() + 'a'));
//         return sb.reverse().toString();
//     }
// }