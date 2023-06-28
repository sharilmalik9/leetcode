// https://leetcode.com/problems/happy-number

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs= new HashSet<>();
        while(n!=1 && !hs.contains(n)){
            hs.add(n);
            int ans=0;
            while(n>0){
                int rem=n%10;
                n=n/10;
                ans+=rem*rem;
                
            }
            n=ans;

       
    }
    if(n==1){
          return true;
    }
    else{
        return false;
    }
    }
}