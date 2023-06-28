// https://leetcode.com/problems/reverse-words-in-a-string

class Solution {
    public String reverseWords(String s) {
        List<String> ls= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }
            else{
                int j=i;
                while(j<s.length()){
                    if(s.charAt(j)==' '){
                        break;
                    }
                    else{
                        j++;
                    }
                }
                ls.add(s.substring(i,j));
                i=j;
            }
        }
        StringBuilder sb= new StringBuilder();
        for(int i=ls.size()-1;i>=0;i--){
            sb.append(ls.get(i));
            sb.append(' ');
            
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}