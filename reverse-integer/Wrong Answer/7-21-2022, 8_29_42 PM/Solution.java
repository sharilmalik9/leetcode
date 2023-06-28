// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        int  ans=0;
        boolean check=false;
        if(x<0){
            check=true;
            x=-x;
            
}
        while(x>0){
            int rem=x%10;
             x=x/10;
            if(ans<Integer.MAX_VALUE){
                 ans=ans*10+rem;

            }
          else{
              return 0;
          }
}
        System.out.println(ans);
        if(ans>Integer.MAX_VALUE){
            return 0;
}
        if(check){
            ans=-ans;
        }
       
        return ans;
        
    }
}