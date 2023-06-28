// https://leetcode.com/problems/push-dominoes

class Solution {
    public String pushDominoes(String d) {
     int right=0;
        int[] rightarr= new int[d.length()];
     for(int i=0;i<d.length();i++){
         if(d.charAt(i)=='R'){
             right=i;
             break;
         }
         
         
     }
    for(int i=0;i<d.length();i++){
        if(d.charAt(i)=='.' && i-right>0){
        rightarr[i]=right;
        }
        else if(d.charAt(i)=='R'){
            right=i;
        }
        
    }
        int left=0;
        int[] leftarr= new int[d.length()];
     for(int i=d.length()-1;i>=0;i--){
         if(d.charAt(i)=='L'){
             left=i;
             break;
         }
         
         
     }
    for(int i=d.length()-1;i>=0;i--){
        if(d.charAt(i)=='.' && i-left<0){
            leftarr[i]=left;
        }
        else if(d.charAt(i)=='R'){
            left=i;
        }
        
    }
        System.out.println(Arrays.toString(leftarr));
         System.out.println(Arrays.toString(rightarr));
        
        char[] ans= new char[d.length()];
        for(int i=0;i<d.length();i++){
            if(d.charAt(i)=='.'){
                if(leftarr[i]-i<i-rightarr[i]){
                    
                    ans[i]='L';
                }
                else if(leftarr[i]-i>i-rightarr[i]){
                    ans[i]='R';
                }
                else{
                    ans[i]='.';
                }
                
            }
            else{
                ans[i]=d.charAt(i);
            }
        }
        System.out.println(Arrays.toString(ans));
        StringBuilder sbf
            = new StringBuilder("");
        sbf.append(ans);
        return sbf.toString();
        
        
    }
}