// https://leetcode.com/problems/swap-adjacent-in-lr-string

class Solution {
    public boolean canTransform(String start, String end) {
        int idx1=0;
        int idx2=0;
        if(start.length()!=end.length()){
            return false;
        }
        while(idx1<start.length()-1){
            if(start.charAt(idx1)==end.charAt(idx2)){
                idx1++;
                idx2++;
                continue;
            }
            String st=start.substring(idx1,idx1+2);
            String en=end.substring(idx2,idx2+2);
            System.out.println(st);
            if(st.compareTo("XL")==0){
                if(en.compareTo("LX")==0){
                    idx1+=2;
                    idx2+=2;
                }
                else{
                    return false;
                }
            }
            else if(st.compareTo("RX")==0){
                if(en.compareTo("XR")==0){
                    idx1+=2;
                    idx2+=2;

                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        if(idx1==start.length()-2){
            if(start.charAt(idx1++)!=end.charAt(idx2++)){
                return false;
            }
        }
        if(idx1==0){
             if(start.charAt(0)!=end.charAt(0)){
                return false;
            }
        }
        return true;
    }
}