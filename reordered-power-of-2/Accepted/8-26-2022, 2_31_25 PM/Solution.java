// https://leetcode.com/problems/reordered-power-of-2

class Solution {
    
    public ArrayList<Integer> intToArray(int n){
        ArrayList<Integer> arr = new ArrayList<>();
        while(n>0){
            int d = n%10;
            n = n/10;
            arr.add(d);
        }
        
        return arr;
    }
    
    public boolean compare(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        if(arr1.size() != arr2.size()){
            return false;
        }
        
        Collections.sort(arr1);        
        Collections.sort(arr2);
        
        for(int i =0; i<arr1.size(); i++){
            if(arr1.get(i) != arr2.get(i)){
                return false;
            }
        }
        return true;

        
    }
    
    
    
    public boolean reorderedPowerOf2(int n) {
        
        ArrayList<Integer> nums = new ArrayList<>();
        
        for(int i = 0;i<30; i++){
          nums.add((int)Math.pow(2,i));
        }
        
        ArrayList<Integer> hello = intToArray(n);
        
        for(int i=0; i<30; i++){
            ArrayList<Integer> hi = intToArray(nums.get(i));
            if(compare(hello,hi)){
                return true;
            }
        }
        return false;
        
    }
   
    
}