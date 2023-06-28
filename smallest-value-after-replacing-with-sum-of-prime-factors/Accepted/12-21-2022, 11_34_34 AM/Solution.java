// https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors

class Solution {
    public int smallestValue(int n) {
        if(isPrime(n)){
            return n;
        }
        int sum=Prime(n);
        if(sum==n){
           
            return n;
        }
        return smallestValue(sum);
        
    }
    public boolean isPrime(int n ){
        for(int i=2;i<n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public int FirstPrime(int n){
        if(isPrime(n)){
            return n;
        }
        for(int i=2;i<n/2;i++){
            if(n%i==0){
                return i;
            }
        }
        return -1;
    }
    public int Prime(int n){
        int sum =0;
        if(isPrime(n)){
            sum=n;
            return sum;
        }
        while(!isPrime(n)){
            int m =FirstPrime(n);
                n=n/m;
                sum+=m;
            
        }
        sum+=n;
        return sum;
    }
}