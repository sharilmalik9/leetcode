// https://leetcode.com/problems/unique-number-of-occurrences

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
       Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Map<Integer, Boolean> duplicateCount = new HashMap<>();
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int value = entry.getValue();
            
            if(duplicateCount.containsKey(value)){
                return false;
            }
            
            duplicateCount.put(value, true);
        }
        
        return true; 
    }
}