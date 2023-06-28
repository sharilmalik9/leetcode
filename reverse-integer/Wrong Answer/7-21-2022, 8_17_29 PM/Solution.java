// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {
        int ans=0;
        boolean check=false;
        if(x<0){
            check=true;
            x=-x;
            
}
        while(x>0){
            int rem=x%10;
             x=x/10;
            ans=ans*10+rem;
}
        System.out.println(ans);
        if(check){
            ans=-ans;
        }
        if(ans>Integer. MAX_VALUE && ans<Integer.MIN_VALUE){
            return 0;
        }
        return ans;
        
    }
}