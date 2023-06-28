// https://leetcode.com/problems/the-kth-factor-of-n

class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=1;i<n/2+1;i++){
            if(n%i==0){
                arr.add(i);
            }
        }
        arr.add(n);
        System.out.println(arr);
        if(arr.size()<=k-1){
            return -1;
        }
        else{
            return arr.get(k-1);
        }
    }
}