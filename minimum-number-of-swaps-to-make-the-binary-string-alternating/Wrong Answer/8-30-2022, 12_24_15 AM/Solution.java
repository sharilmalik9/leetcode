// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating

class Solution {
    int noOne=0;
    int noZero=0;
    int ansf=Integer.MAX_VALUE;
    public int minSwaps(String s) {
        countOneZero(s);
        rec(s,"");
            return ansf; 
        
    }
    public void rec(String s,String ans){
        if(ans.length()==s.length()){
            if(checkAlter(ans)){
                System.out.println(ans);
                ansf=Math.min(ansf,maxDifference(s,ans)/2);
            }
            
            return;
            
        }
        if(noOne>0 ){
             rec(s,ans+"1");
            noOne++;
        }
        if(noZero>0){
            rec(s,ans+"0");
            noZero++;
        }
        
    }
    public int maxDifference(String s ,String curr){
        
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=curr.charAt(i)){
                cnt++;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
    public boolean checkAlter(String curr){
        for(int i=0;i<curr.length()-1;i++){
            
            if(curr.charAt(i)==curr.charAt(i+1)){
                return false;
            }
}
        return true;
    }
    
    
    public void countOneZero(String s){
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(c=='0'){
                noZero++;
            }
            else{
                noOne++;
            }
        }
    }
}