// https://leetcode.com/problems/text-justification

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int curLength = words[0].length();
        int start = 0;
        for(int i = 1; i <= words.length;i++){
            if(i == words.length ||  curLength + words[i].length() + i - start > maxWidth ){
                int end = i - 1;
                StringBuilder sb = new StringBuilder();
                if(i == words.length){
                    while(start < end ){
                        sb.append(words[start]);
                        sb.append(" ");
                        start++;
                    }
                    sb.append(words[start]);
                    int space = maxWidth - sb.length();
                    while(space > 0){
                    sb.append(" ");
                    space--;
                    }
                    res.add(sb.toString());
                    continue; 
                }else{
                    if(start == end){
                        int remain = maxWidth - words[start].length();
                        sb.append(words[start]);
                        while(remain > 0){
                            sb.append(" ");
                            remain--;
                        }
                    res.add(sb.toString());
                    start = i;
                    if(i < words.length){curLength =words[i].length();} 
                    continue;  
                    }

                }
                int numOfSpace = (maxWidth - curLength )/ (end - start);
                int numOfMore = (maxWidth - curLength) %(end - start);
                while(start < end){
                   sb.append(words[start]);
                   if(numOfMore > 0){
                       sb.append(" ");
                       numOfMore--;
                   }
                   int tem = numOfSpace;
                   while(tem > 0){
                       sb.append(" ");
                       tem--;
                   }
                   start++;
                }
                sb.append(words[start]);
                res.add(sb.toString());
                start = i;
                if(i < words.length){curLength = words[i].length();}
            }else{
               curLength +=  words[i].length();
            }
        }
        return res;
    }
}