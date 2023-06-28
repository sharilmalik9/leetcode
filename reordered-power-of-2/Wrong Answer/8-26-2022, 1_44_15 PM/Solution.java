// https://leetcode.com/problems/reordered-power-of-2

class Solution {
     HashSet<Integer> hp= new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        if(n==1){
            return true;
        }
        int val=n;
        while(val>0){
            hp.add(val%10);
            val=val/10;
        }
        for(int i=0;i<30;i++){
        double curr=Math.pow(2,i);
            if(check(curr,n)){
                return true;
            }
}
        return false;
        
    }
    public boolean check(double curr,int n){
        while(curr>0){
            if(!hp.contains(curr%10)){
                return false;
            }
            curr=curr/10;

        }
        return true;
        
        
        
        
    }
}