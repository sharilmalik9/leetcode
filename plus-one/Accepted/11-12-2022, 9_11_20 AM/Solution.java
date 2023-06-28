// https://leetcode.com/problems/plus-one

class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        int sum, carry=1;
        for(int i=digits.length-1;i>=0;i--){
            sum=carry+digits[i];
            arrayList.add(sum%10);
            carry=sum/10;
        }
        if(carry>0)arrayList.add(1);

        int[] out= new int[arrayList.size()];

        for(int i=0;i<arrayList.size();i++){
            out[i]=arrayList.get(arrayList.size()-1-i);
        }

        return out;
    }
}