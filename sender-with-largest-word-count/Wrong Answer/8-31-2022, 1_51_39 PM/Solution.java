// https://leetcode.com/problems/sender-with-largest-word-count

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> hp= new HashMap<>();
        int max=Integer.MIN_VALUE;
        String maxstr="";
        for(int i=0;i<senders.length;i++){
            int cnt=cntWords(messages[i]);
            hp.put(senders[i],hp.getOrDefault(senders[i],0)+cnt);
           if(hp.get(senders[i])>max){
               max=hp.get(senders[i]);
               maxstr=senders[i];
           } 
            else if(hp.get(senders[i])==max){
                if(maxstr.compareTo(senders[i])>0){
                    maxstr=senders[i];
}
            }
       }
        return maxstr;
        
        
    }
    public int cntWords(String message){
        int cnt=1;
        for(int i=0;i<message.length();i++){
            if(message.charAt(i)==' '){
                cnt++;
                }
          }
        return cnt;
      }
}