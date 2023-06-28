// https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0

class Solution {
    HashSet<Integer> hs= new HashSet<>();

    public int minOperations(int n) {
        if(n==1){
            return 1;
        }
        hs.add(1);
        int curr=2;
        while(curr<n){
            hs.add(curr);
            if(curr==n){
                return 1;
            }
            curr=curr*2;
        }
        hs.add(curr*2);
        return 1+Math.min(help(curr-n),help(n-curr/2));

        
    }
    public int help(int num){
        if(hs.contains(num)){
            return 1;
        }
        int upper =num;
        int lower=num;
        while(lower>0){
            lower--;
            if(hs.contains(lower)){
                break;
            }

        }
        while(!hs.contains(upper)){
            upper++;
        }
        return 1+Math.min(help(num-lower),help(upper-num));

        
    }
}